package com.example.collection.utils;

import com.example.collection.list.LinkedList;
import com.example.collection.list.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ListAlgorithmsTest {
    private List<Integer> linkedList;

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
    }

    @Test
    void shouldFindNMaxElements() {
        Object[] twoMaxElements = ListAlgorithms.findNMaxElements(linkedList, 2);
        assertEquals(8, twoMaxElements[0]);
        assertEquals(9, twoMaxElements[1]);

        List<Integer> testList = new LinkedList<>();
        testList.add(5);
        testList.add(2);
        testList.add(4);
        testList.add(1);
        twoMaxElements = ListAlgorithms.findNMaxElements(testList, 2);
        assertEquals(4, twoMaxElements[0]);
        assertEquals(5, twoMaxElements[1]);

        Object[] moreMaxElements = ListAlgorithms.findNMaxElements(testList, 9);
        assertEquals(1, moreMaxElements[0]);
        assertEquals(2, moreMaxElements[1]);
        assertEquals(4, moreMaxElements[2]);
        assertEquals(5, moreMaxElements[3]);

        twoMaxElements = ListAlgorithms.findNMaxElements(linkedList, 10);
        Arrays.asList(twoMaxElements).forEach(System.out::println);
    }
}
