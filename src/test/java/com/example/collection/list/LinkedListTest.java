package com.example.collection.list;

import com.example.collection.iterator.Iterator;
import com.example.collection.utils.ListAlgorithms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private List<Integer> linkedList;
    private List<Integer> emptyList;

    @BeforeEach
    void init() {
        linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(8);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(3);
        linkedList.add(9);
        linkedList.add(0);

        emptyList = new LinkedList<>();
    }

    @Test
    void shouldAdd() {
        emptyList.add(1);
        emptyList.add(2);
        emptyList.add(3);

        ListAlgorithms.printAll(linkedList);
        assertEquals(3, emptyList.size());
    }

    @Test
    void shouldRemove() {
        boolean isRemovedFour = linkedList.remove(4);
        boolean isRemovedThree = linkedList.remove(3);

        ListAlgorithms.printAll(linkedList);
        assertEquals(6, linkedList.size());
        assertTrue(isRemovedFour);
        assertTrue(isRemovedThree);
    }

    @Test
    void shouldRemoveNonExistElement() {
        boolean isRemoved = emptyList.remove(1);

        assertFalse(isRemoved);
    }

    @Test
    void containsTest() {
        boolean isContains = linkedList.contains(4);
        assertTrue(isContains);

        isContains = linkedList.contains(10);
        assertFalse(isContains);
    }

    @Test
    void iteratorTest() {
        Iterator<Integer> iterator = linkedList.getIterator();
        assertEquals(1, iterator.next());
        assertEquals(5, iterator.next());
        assertEquals(8, iterator.next());
        assertEquals(4, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(9, iterator.next());
        assertEquals(0, iterator.next());
        assertFalse(iterator.hasNext());
    }
}