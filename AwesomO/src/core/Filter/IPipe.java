package core.Filter;

/**
 * Java generic pipe and filter classes
 * @author roryokane
 */
public interface IPipe<T> {
    public boolean put(T obj);
    public T nextOrNullIfEmptied() throws InterruptedException;
    public void closeForWriting();
}
