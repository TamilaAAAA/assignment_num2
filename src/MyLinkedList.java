class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        public MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addElement(T element) {
        MyNode newNode = new MyNode(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addElement(T element, int index) {
        checkIndex(index);
        if (index == size) {
            addElement(element);
            return;
        }
        MyNode newNode = new MyNode(element);
        MyNode current = getNodeAtIndex(index);
        MyNode prev = current.prev;

        newNode.next = current;
        current.prev = newNode;

        if (prev == null) {
            head = newNode;
        } else {
            prev.next = newNode;
            newNode.prev = prev;
        }
        size++;
    }

    public T getElement(int index) {
        checkIndex(index);
        return getNodeAtIndex(index).data;
    }

    public int getSize() {
        return size;
    }

    public void removeElement(int index) {
        checkIndex(index);
        MyNode current = getNodeAtIndex(index);
        MyNode prev = current.prev;
        MyNode next = current.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
        }
        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    private MyNode getNodeAtIndex(int index) {
        checkIndex(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index not correct");
        }
    }

    public MyIterator<T> iterator() {
        return new MyLinkedListIterator<>();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void add(int i, T last) {

    }

    private class MyLinkedListIterator<E> implements MyIterator<E> {
        private MyNode current = head;

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new ArrayIndexOutOfBoundsException("No more elements");
            }
            E data = (E) current.data;
            current = current.next;
            return data;
        }
    }
}