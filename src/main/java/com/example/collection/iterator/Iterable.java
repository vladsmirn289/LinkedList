package com.example.collection.iterator;

/**
 * Provides a factory method that creates a specific iterator.
 *
 * @param <T> the type of elements
 */
public interface Iterable<T> {
    /**
     * Returns a specific iterator.
     *
     * @return a specific iterator
     */
    Iterator<T> getIterator();
}
