package com.example.collection;

/**
 * A simple node which needed to implement the linked list structure.
 * It is a holder that stores the value and also has the pointer
 * to the next node. If the current node is tail, the pointer to
 * the next will be null.
 *
 * @param <E> the type of value that can be stored in node
 */
public class Node<E> {
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
