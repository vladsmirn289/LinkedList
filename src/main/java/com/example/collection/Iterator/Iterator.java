package com.example.collection.Iterator;

/**
 * Common iterator which can iterate all elements calling the
 * corresponding method. It supplies an opportunity to check whether
 * iterator is exhausted. If iterator is exhausted you will no longer
 * be able to use it.
 *
 * @param <T> the type of elements
 */
public interface Iterator<T> {
    /**
     * Returns the current value pointed to by the iterator.
     *
     * @return the next value in collection
     */
    T next();

    /**
     * Checks whether the next element is present or not.
     *
     * @return true if the next value is exists, false otherwise
     */
    boolean hasNext();
}
