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
