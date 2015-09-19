package core;

import core.Filter.Doorbell.DoorbellFilter;
import core.Filter.BooleanSink;
import core.Filter.Doorbell.DoorbellEnum;
import core.Filter.Filter;
import core.Filter.Pipe;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sander
 */
public class DoorbellTest {
    
    public DoorbellTest() {
    }
    @Test
    public void TestDoorbellFilter() throws InterruptedException 
    {
        Pipe<Enum> input = new Pipe<>();
        Pipe<Boolean> output = new Pipe<>();

        input.put(DoorbellEnum.Opened);
        
        Filter<Enum, Boolean> filter = new DoorbellFilter(input, output);
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
