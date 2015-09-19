package core.Filter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Java generic pipe and filter classes
 * @author roryokane
 */
public class Pipe<T> implements IPipe<T> {
    private Queue<T> buffer = new LinkedList<>();
    private boolean isOpenForWriting = true;
    private boolean hasReadLastObject = false;

    @Override
    public synchronized boolean put(T obj) {
        if (!isOpenForWriting) {
            throw new RuntimeException(new IOException("pipe is closed; cannot write to it"));
        } else if (obj == null) {
            throw new IllegalArgumentException("cannot put null in pipe; null is reserved for pipe-empty sentinel value");
        }

        boolean wasAdded = buffer.add(obj);
        notify();
        return wasAdded;
    }

    @Override
    public synchronized T nextOrNullIfEmptied() throws InterruptedException {
        if (hasReadLastObject) {
            throw new NoSuchElementException("pipe is closed and empty; will never contain any further values");
        }

        while (buffer.isEmpty()) {
            wait(); // pipe empty - wait
        }

        T obj = buffer.remove();
        if (obj == null) { // will be null if it's the last element
            hasReadLastObject = true;
        }
        return obj;
    }

    @Override
    public synchronized void closeForWriting() {
        isOpenForWriting = false;
        buffer.add(null);
        notify();
    }
}
