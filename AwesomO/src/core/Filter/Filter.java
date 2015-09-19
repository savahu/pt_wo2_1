package core.Filter;

/**
 * Java generic pipe and filter classes
 * @author roryokane
 */
public abstract class Filter<I, O> extends ThreadedRunner {

    protected IPipe<I> input;
    protected IPipe<O> output;

    
    public Filter(IPipe<I> input, IPipe<O> output) {
        this.input = input;
	this.output = output;
    }

    @Override
    public void run() {
        transformBetween(input, output);
    }

    protected void transformBetween(IPipe<I> input, IPipe<O> output) {
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
