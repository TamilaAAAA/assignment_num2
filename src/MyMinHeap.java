class MyMinHeap<T extends Comparable<T>> {
    private MyList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    public void add(T element) {
        list.addElement(element);
        heapifyUp(list.getSize() - 1);
    }

    public T peek() {
        if (list.getSize() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return list.getElement(0);
    }

    public T remove() {
        if (list.getSize() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = list.getElement(0);
        T last = list.getElement(list.getSize() - 1);
        list.removeElement(list.getSize() - 1);
        if (!list.isEmpty()) {
            list.add(0, last);
            heapifyDown(0);
        }
        return min;
    }

    public int size() {
        return list.getSize();
    }

    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && list.getElement(index).compareTo(list.getElement(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < list.getSize() && list.getElement(leftChildIndex).compareTo(list.getElement(smallestIndex)) < 0) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < list.getSize() && list.getElement(rightChildIndex).compareTo(list.getElement(smallestIndex)) < 0) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            swap(index, smallestIndex);
            heapifyDown(smallestIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = list.getElement(i);
        list.addElement(list.getElement(j), i);
        list.addElement(temp, j);
    }
}