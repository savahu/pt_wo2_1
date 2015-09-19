
/**
 *
 * @author Dominique
 */
package core;

import core.Filter.Coffee.CoffeeFilter;
import core.Filter.BooleanSink;
import core.Filter.Coffee.CoffeeEnum;
import core.Filter.Filter;
import core.Filter.Pipe;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CoffeeTest {
    
    public CoffeeTest() {
    }

    @Test
    public void TestCoffeeFilter() throws InterruptedException 
    {
        Pipe<Enum> input = new Pipe<>();
        Pipe<Boolean> output = new Pipe<>();

        input.put(CoffeeEnum.Ready);
        
        Filter<Enum, Boolean> filter = new CoffeeFilter(input, output);
        BooleanSink sink = new BooleanSink(output);

        filter.start();
        sink.start();

        filter.stop();
        sink.stop();
        
        Thread.sleep(300);
        
        System.out.println("test finished");
        
        Assert.assertEquals(true, (boolean)sink.getOutput());
    }
}
