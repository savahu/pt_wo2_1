/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.Filter;

/**
 *
 * @author sander
 */
public abstract class Filter<I, O> extends ThreadedRunner {

    protected Pipe<I> input;
    protected Pipe<O> output;

    
    public Filter(Pipe<I> input, Pipe<O> output) {
        this.input = input;
	this.output = output;
    }

    @Override
    public void run() {
        transformBetween(input, output);
    }

    protected void transformBetween(Pipe<I> input, Pipe<O> output) {
        try {
            I in;
            while ((in = input.nextOrNullIfEmptied()) != null) {
                O out = transformOne(in);
                output.put(out);
            }
        } catch (InterruptedException e) {
            System.err.println("InterruptedException occurred");
            return;
        }
        output.closeForWriting();
    }

    protected abstract O transformOne(I in);
}
