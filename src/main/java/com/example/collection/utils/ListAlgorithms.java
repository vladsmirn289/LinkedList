package com.example.collection.utils;

import com.example.collection.iterator.Iterator;
import com.example.collection.list.List;

/**
 * Contains some specific algorithms that can
 * be reused.
 */
public class ListAlgorithms {
    /**
     * Prints all elements that list is contains.
     *
     * @param list collection of elements
     * @param <T> type of elements
     */
    public static <T> void printAll(List<T> list) {
        Iterator<T> iterator = list.getIterator();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            if (iterator.hasNext()) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }

    /**
     * Finds specified count of maximum numbers from collection.
     * If N equals 0, returns an empty array. If N greater than size
     * of collection, returns all elements is sorted order.
     *
     * @param list collection of elements
     * @param N count of maximum objects
     * @param <T> type of collection elements
     * @return an object array of N maximum objects in list
     */
    public static <T extends Comparable<? super T>> Object[] findNMaxElements(List<T> list, int N) {
        int listSize = list.size();
        if (listSize == 0) {
            return new Object[0];
        }

        if (N > listSize) {
            N = listSize;
        }

        Iterator<T> iterator = list.getIterator();
        Object[] maxElements = new Object[N];
        while (iterator.hasNext()) {
            T element = iterator.next();

            //If array has null elements, shift elements from right to left
            if (maxElements[N-1] == null) {
                for (int i = 0; i < N; ++i) {
                    if (maxElements[i] == null) {
                        maxElements[i] = element;
                        break;
                    }

                    if (element.compareTo((T) maxElements[i]) >= 0) {
                        continue;
                    }

                    for (int k = N-1; k > i; --k) {
                        Object tempToSwap = maxElements[k];
                        maxElements[k] = maxElements[k-1];
                        maxElements[k-1] = tempToSwap;
                    }

                    maxElements[i] = element;
                    break;
                }
            } else { //Else shift elements from left to right
                for (int i = N-1; i >= 0; --i) {
                    if (element.compareTo((T) maxElements[i]) <= 0) {
                        continue;
                    }

                    for (int k = 1; k <= i; ++k) {
                        Object tempToSwap = maxElements[k];
                        maxElements[k] = maxElements[k-1];
                        maxElements[k-1] = tempToSwap;
                    }

                    maxElements[i] = element;
                    break;
                }
            }
        }

        return maxElements;
    }
}
