class MyQueue<T> {
    private MyList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T element) {
        list.addElement(element);
    }

    public T dequeue() {
        if (list.getSize() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = list.getElement(0);
        list.removeElement(0);
        return element;
    }

    public T peek() {
        if (list.getSize() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getElement(0);
    }

    public int size() {
        return list.getSize();
    }

    public boolean isEmpty() {
        return list.getSize() == 0;
    }
}