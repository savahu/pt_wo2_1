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
public interface Pipe<T> {
    public boolean put(T obj);
    public T nextOrNullIfEmptied() throws InterruptedException;
    public void closeForWriting();
}
