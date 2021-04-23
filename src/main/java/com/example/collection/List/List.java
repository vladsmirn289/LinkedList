package com.example.collection.List;

/**
 * A list represents an ordered collection which can store
 * duplicates. The user can add an element to end of it,
 * remove concrete element, check whether list contains
 * some item or not and also to see the number of stored elements.
 *
 * @param <T> the type of all elements in list
 * @author Vladislav Smirnov
 * @see LinkedList
 */
public interface List<T> {
    /**
     * Returns the number of all stored elements in this list.
     *
     * @return the number of stored elements
     */
    int size();

    /**
     * Appends the new element to the end of this list.
     *
     * @param newElement element that will be added to the end of this list.
     */
    void add(T newElement);

    /**
     * Removes the concrete element from this list. If the element is not
     * in the list, nothing happens.
     *
     * @param toRemove element which will be removed from this list.
     * @return true if element was removed from the list, false otherwise.
     */
    boolean remove(T toRemove);

    /**
     * Check whether the concrete element is contains in this list or not.
     *
     * @param element element which will be tested on presence in this list.
     * @return true if the element is contains in this list, false otherwise.
     */
    boolean contains(T element);
}
