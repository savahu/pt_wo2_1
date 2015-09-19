package core.Filter;

/**
 *
 * @author sander
 */
public class DoorbellFilter extends Filter<Enum, Boolean> {

    public DoorbellFilter(IPipe<Enum> input, IPipe<Boolean> output) {
        super(input, output);
    }

    @Override
    protected Boolean transformOne(Enum in) {
        Boolean out = in.equals(DoorbellEnum.Opened);
        System.out.println("filtered " + in.toString() + " to " + out.toString());
        return out;
    }
}

	
 
