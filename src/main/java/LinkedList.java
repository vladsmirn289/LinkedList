public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {

    }

    private static class Node<E> {
        private Node<E> next;
        private E value;

        public Node(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getElement() {
            return value;
        }

        public void setElement(E value) {
            this.value = value;
        }
    }

    public int size() {
        return size;
    }

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
                current = null; //for garbage collector
            }

            --size;
            return true;
        }

        return false;
    }

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

    public Object[] findNMaxElements(int N) {
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
    }
}
