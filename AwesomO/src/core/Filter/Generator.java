package core.Filter;

/**
 *
 * @author sander
 */
public abstract class Generator<T> extends ThreadedRunner {
    protected IPipe<T> output;

    public Generator(IPipe<T> output) {
        this.output = output;
    }

    @Override
    public void run() {
        generateInto(output);
    }

    public abstract void generateInto(IPipe<T> pipe);
}
