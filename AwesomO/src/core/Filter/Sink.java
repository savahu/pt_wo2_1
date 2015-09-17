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
public abstract class Sink<T> extends ThreadedRunner {
    protected Pipe<T> input;

    public Sink(Pipe<T> input) {
        this.input = input;
    }

    @Override
    public void run() {
        takeFrom(input);
    }
    
     public void takeFrom(Pipe<T> pipe) {
        try {
            T in;
            while ((in = pipe.nextOrNullIfEmptied()) != null) {
                handle(in);
            }
        } catch (InterruptedException e) {
            System.err.println("InterruptedException occurred");
        } finally {
            cleanup();
        }
    }

    protected abstract void handle(T in);

    protected void cleanup() {
    }
}
