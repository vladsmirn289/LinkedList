package com.example.collection.List;

import com.example.collection.Iterator.Iterator;
import com.example.collection.Iterator.LinkedListIterator;
import com.example.collection.Node;

/**
 * A collection represents an ordered, unidirectional list which
 * can store duplicates. The user can add an element to end of it,
 * remove concrete element, check whether list contains
 * some item or not and also to see the number of stored elements.
 *
 * @param <T> the type of all elements in LinkedList
 * @author Vladislav Smirnov
 */
public class LinkedList<T> implements List<T> {
    /**
     * First node in list.
     */
    private Node<T> head;

    /**
     * Keeps the number of elements.
     */
    private int size;

    /**
     * Constructs an empty linked list.
     */
    public LinkedList() {

    }

    /**
     * Returns the number of all stored elements in this list.
     *
     * @return the number of stored elements
     */
    public int size() {
        return size;
    }

    /**
     * Appends the new element to the end of this list.
     *
     * @param newElement element that will be added to the end of this list
     */
    public void add(T newElement) {
        Node<T> newNode = new Node<T>(newElement);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(newNode);
        }

        ++size;
    }

    /**
     * Removes the concrete element from this list. If the element is not
     * in the list, nothing happens.
     *
     * @param toRemove element which will be removed from this list
     * @return true if element was removed from the list, false otherwise
     */
    public boolean remove(T toRemove) {
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            boolean isCurrentEqualsToRemove = current.getValue().equals(toRemove);
            boolean isPreviousNull = previous == null;
            if (!isCurrentEqualsToRemove) {
                previous = current;
                current = current.getNext();

                continue;
            }

            if (isPreviousNull) {
                head = current.getNext();
            } else {
                previous.setNext(current.getNext());
            }

            --size;
            return true;
        }

        return false;
    }

    /**
     * Checks whether the concrete element is contains in this list or not.
     *
     * @param element element which will be tested on presence in this list
     * @return true if the element is contains in this list, false otherwise
     */
    public boolean contains(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.getValue().equals(element)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    /**
     * Returns a specific LinkedListIterator which
     * starts from head.
     *
     * @return an iterator
     */
    public Iterator<T> getIterator() {
        return new LinkedListIterator<T>(head);
    }

    //TODO: replace to another class
    /*public Object[] findNMaxElements(int N) {
        Object[] elements = getAllInArray();

        for (int i = 0; i < size; ++i) {
            for (int k = i+1; k < size; ++k) {
                String first = elements[i].toString();
                String second = elements[k].toString();
                if (first.compareTo(second) > 0) {
                    Object tempToSwap = elements[i];
                    elements[i] = elements[k];
                    elements[k] = tempToSwap;
                }
            }
        }

        int counter = 0;
        Object[] nMaxElements = new Object[N];
        int initIndex = size - N;

        if (initIndex < 0) {
            initIndex = 0;
        }

        while (initIndex < size) {
            nMaxElements[counter] = elements[initIndex];
            ++initIndex;
            ++counter;
        }

        return nMaxElements;
    }

    public Object[] getAllInArray() {
        int counter = 0;
        Object[] elements = new Object[size];
        Node<T> current = head;
        while (current != null) {
            elements[counter] = current.value;
            current = current.next;
            ++counter;
        }

        return elements;
    }

    public void printAll() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }*/
}
