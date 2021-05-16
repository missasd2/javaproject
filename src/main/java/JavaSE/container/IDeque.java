package JavaSE.container;

import java.util.Iterator;
import java.util.Map;

public interface IDeque<E> extends IQueue<E> {


    void addFirst(E e);

    void addLast(E e);

    boolean offerFirst(E e);

    boolean offerLast(E e);

    E removeFirst();

    E removeLast();

    E pollFirst();

    E pollLast();

    E getFirst();

    E getLast();

    E peekFirst();

    E peekLast();

    boolean removeFirstOccurrence(Object o);

    boolean removeLastOccurrence(Object o);

    boolean add(E e);

    boolean offer(E e);

    E remove();

    E poll();

    E element();

    E peek();

    void push();

    E pop();

    boolean remove(Object e);

    public int size();

    Iterator<E> iterator();

    Iterator<E> descendingIterator();






}
