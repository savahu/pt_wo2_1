/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.Filter;

/**
 *
 * @author sander
 */
public class DoorbellFilter extends Filter<Integer, String> {

    public DoorbellFilter(Pipe<Integer> input, Pipe<String> output) {
        super(input, output);
    }

    @Override
    protected String transformOne(Integer in) {
        String out = Integer.toString(in);
        System.out.println("filtered " + Integer.toString(in) + " to " + out);
        return out;
    }
}
