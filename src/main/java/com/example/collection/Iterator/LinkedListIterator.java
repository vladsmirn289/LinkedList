package com.example.collection.Iterator;

import com.example.collection.Node;

/**
 * Iterator which iterate all elements from head to tail by
 * corresponding nodes.
 *
 * @param <T> the type of elements
 */
public class LinkedListIterator<T> implements Iterator<T> {
    /**
     * Current position of iterator.
     */
    private Node<T> pointer;

    /**
     * Constructs an iterator by first node.
     *
     * @param pointer first element that the iterator starts with
     */
    public LinkedListIterator(Node<T> pointer) {
        this.pointer = pointer;
    }

    /**
     * Returns the current value pointed to by the iterator.
     *
     * @return the next element in collection
     * @throws IllegalStateException if the iterator is exhausted
     */
    public T next() {
        if (pointer == null) {
            throw new java.lang.IllegalStateException("No other elements, iterator is exhausted.");
        }

        T value = pointer.getValue();
        pointer = pointer.getNext();

        return value;
    }

    /**
     * Checks whether the next element is present or not.
     *
     * @return true if the next value is exists, false otherwise
     */
    public boolean hasNext() {
        return pointer != null;
    }
}
