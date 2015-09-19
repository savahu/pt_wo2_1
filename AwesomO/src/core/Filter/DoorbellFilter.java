package core.Filter;

/**
 *
 * @author sander
 */
public class DoorbellFilter extends Filter<Integer, String> {

    public DoorbellFilter(IPipe<Integer> input, IPipe<String> output) {
        super(input, output);
    }

    @Override
    protected String transformOne(Integer in) {
        String out = Integer.toString(in);
        System.out.println("filtered " + Integer.toString(in) + " to " + out);
        return out;
    }
}
