package core.Filter;

/**
 *
 * @author sander
 */
public interface IPipe<T> {
    public boolean put(T obj);
    public T nextOrNullIfEmptied() throws InterruptedException;
    public void closeForWriting();
}
