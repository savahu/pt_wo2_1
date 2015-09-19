package core.Filter;

/**
 *
 * @author sander
 */
public class BooleanSink extends Sink<Boolean> {

    private Boolean Output;

    public BooleanSink(IPipe<Boolean> input) {
        super(input);
    }

    public Boolean getOutput() {
        return Output;
    }

    @Override
    public void takeFrom(IPipe<Boolean> pipe) {
        try {
            Boolean in;
            while ((in = pipe.nextOrNullIfEmptied()) != null) {
                System.out.println(in);
                Output = in;
                //delayForDebug(300);
            }
            System.out.println("sink finished");
        } catch (InterruptedException e) {
            System.err.println("interrupted");
            e.printStackTrace();
        } finally {
            System.out.close();
        }
    }

    @Override
    protected void handle(Boolean in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
