package core.Filter;

/**
 *
 * @author sander
 */
public abstract class ThreadedRunner implements Runnable {
	private boolean isStarted = false;

    @Override
    abstract public void run();

	public void start(){
	    if(! isStarted){
	        isStarted = true;
	        Thread thread = new Thread(this);
	        thread.start();
	      }
	}

	public void stop(){
		isStarted = false;
	}
}
