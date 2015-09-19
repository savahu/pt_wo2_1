package core.Filter;

/**
 * Java generic pipe and filter classes
 * @author roryokane
 */
public abstract class Sink<T> extends ThreadedRunner {
    protected IPipe<T> input;
    
    public Sink(IPipe<T> input) {
        this.input = input;
    }

    @Override
    public void run() {
        takeFrom(input);
    }
    
     public void takeFrom(IPipe<T> pipe) {
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
