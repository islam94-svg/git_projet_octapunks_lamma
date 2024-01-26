import java.util.Iterator;
import java.util.NoSuchElementException;

public class EmptyIterator<T> implements Iterator<T> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public  next() {
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new IllegalStateException("Cannot remove from an empty iterator");
    }
}
s
