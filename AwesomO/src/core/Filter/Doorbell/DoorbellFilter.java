package core.Filter.Doorbell;

import core.Filter.Filter;
import core.Filter.IPipe;

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
        System.out.println("The state of the door is "+ in.toString());
         System.out.println("Filtered " + in.toString() + " to " + out.toString());
        return out;
    }
}

	
 
