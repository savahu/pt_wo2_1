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
                Output = in;
            }
        } catch (InterruptedException e) {
            System.err.println("InterruptedException occurred: " + e.getStackTrace());
        } finally {
            System.out.close();
        }
    }

    @Override
    protected void handle(Boolean in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
