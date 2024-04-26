class MyStack<T> {
    private MyList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T element) {
        list.addElement(element);
    }

    public T pop() {
        if (list.getSize() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = list.getElement(list.getSize() - 1);
        list.removeElement(list.getSize() - 1);
        return element;
    }

    public T peek() {
        if (list.getSize() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getElement(list.getSize() - 1);
    }

    public int size() {
        return list.getSize();
    }

    public boolean isEmpty() {
        return list.getSize() == 0;
    }
}