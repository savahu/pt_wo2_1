/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.Filter.Coffee;

import core.Filter.Filter;
import core.Filter.IPipe;

/**
 *
 * @author Dominique
 */
public class CoffeeFilter extends Filter<Enum, Boolean> {

    public CoffeeFilter(IPipe<Enum> input, IPipe<Boolean> output) {
        super(input, output);
    }

    @Override
    protected Boolean transformOne(Enum in) {
        Boolean out = in.equals(CoffeeEnum.Ready);
        System.out.println("The coffee state is " + in.toString());
        System.out.println("Filtered " + in.toString() + " to " + out.toString());
        return out;
    }
}
