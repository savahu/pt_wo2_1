package core.Filter;

/**
 *
 * @author sander
 */
public class DoorbellFilter extends Filter<Boolean, String> {

    public DoorbellFilter(IPipe<Boolean> input, IPipe<String> output) {
        super(input, output);
    }

    @Override
    protected String transformOne(Boolean in) {
        //String out = Integer.toString(in)
        System.out.println("filtered " + Integer.toString(in) + " to " + out);
        return out;
    }
}

	
 