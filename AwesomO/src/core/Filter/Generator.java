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
public abstract class Generator<T> extends ThreadedRunner {
    protected Pipe<T> output;

    public Generator(Pipe<T> output) {
        this.output = output;
    }

    @Override
    public void run() {
        generateInto(output);
    }

    public abstract void generateInto(Pipe<T> pipe);
}
