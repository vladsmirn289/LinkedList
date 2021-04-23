package com.example.collection.List;

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
     * Keep the number of elements
     */
    private int size;

    /**
     * Constructs an empty linked list
     */
    public LinkedList() {

    }

    /**
     * A simple node which needed to implement the linked list structure.
     * It is a holder that stores the value and also has the pointer
     * to the next node. If the current node is tail, the pointer to
     * the next will be null.
     *
     * @param <E> the type of value that can be stored in node
     */
    private static class Node<E> {
        /**
         * Stores pointer to the next node.
         */
        private Node<E> next;

        /**
         * Stores the value
         */
        private E value;

        /**
         * Constructs a node with specified value.
         *
         * @param value value that node will be holds.
         */
        public Node(E value) {
            this.value = value;
        }

        /**
         * Returns the next node.
         *
         * @return the next node in current chain.
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * Sets the next node.
         *
         * @param next node that will be next.
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }

        /**
         * Returns the current held value.
         *
         * @return the current held value.
         */
        public E getValue() {
            return value;
        }

        /**
         * Sets the value that will be held this node.
         *
         * @param value value that will be held this node.
         */
        public void setValue(E value) {
            this.value = value;
        }
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
     * @param newElement element that will be added to the end of this list.
     */
    public void add(T newElement) {
        Node<T> newNode = new Node<T>(newElement);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        ++size;
    }

    /**
     * Removes the concrete element from this list. If the element is not
     * in the list, nothing happens.
     *
     * @param toRemove element which will be removed from this list.
     * @return true if element was removed from the list, false otherwise.
     */
    public boolean remove(T toRemove) {
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            boolean isCurrentEqualsToRemove = current.value.equals(toRemove);
            boolean isPreviousNull = previous == null;
            if (!isCurrentEqualsToRemove) {
                previous = current;
                current = current.next;

                continue;
            }

            if (isPreviousNull) {
                head = current.next;
            } else {
                previous.next = current.next;
            }

            --size;
            return true;
        }

        return false;
    }

    /**
     * Check whether the concrete element is contains in this list or not.
     *
     * @param element element which will be tested on presence in this list.
     * @return true if the element is contains in this list, false otherwise.
     */
    public boolean contains(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(element)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    //TODO: remove to another class
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
