import com.example.collection.Iterator.Iterator;
import com.example.collection.List.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList<Integer> linkedList;
    private LinkedList<Integer> emptyList;

    @BeforeEach
    void init() {
        linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(5);
        linkedList.add(8);
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(3);
        linkedList.add(9);
        linkedList.add(0);

        emptyList = new LinkedList<Integer>();
    }

    @Test
    void shouldAdd() {
        emptyList.add(1);
        emptyList.add(2);
        emptyList.add(3);

        assertEquals(3, emptyList.size());
    }

    @Test
    void shouldRemove() {
        boolean isRemovedFour = linkedList.remove(4);
        boolean isRemovedThree = linkedList.remove(3);

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

    /*@Test
    void shouldGetAllInArray() {
        Object[] elements = linkedList.getAllInArray();
        assertEquals(elements[0], 1);
        assertEquals(elements[1], 5);
        assertEquals(elements[2], 8);
        assertEquals(elements[3], 4);
        assertEquals(elements[4], 3);
        assertEquals(elements[5], 3);
        assertEquals(elements[6], 9);
        assertEquals(elements[7], 0);
    }*/

    /*@Test
    void shouldFindNMaxElements() {
        Object[] twoMaxElements = linkedList.findNMaxElements(2);
        assertEquals(8, twoMaxElements[0]);
        assertEquals(9, twoMaxElements[1]);

        com.example.collection.List.LinkedList<Integer> testList = new com.example.collection.List.LinkedList<Integer>();
        testList.add(5);
        testList.add(2);
        testList.add(4);
        testList.add(1);
        twoMaxElements = testList.findNMaxElements(2);
        assertEquals(4, twoMaxElements[0]);
        assertEquals(5, twoMaxElements[1]);

        Object[] moreMaxElements = testList.findNMaxElements(9);
        assertEquals(1, moreMaxElements[0]);
        assertEquals(2, moreMaxElements[1]);
        assertEquals(4, moreMaxElements[2]);
        assertEquals(5, moreMaxElements[3]);
    }*/
}