class MyArrayList<T> implements MyList<T> {
    private T[] arr = (T[]) new Object[5];
    private int size;

    public MyArrayList(){
        size = 0;
    }

    public void addElement(T element){
        if(size >= arr.length){
            increaseBuffer();
        }
        arr[size++] = element;
    }

    public void addElement(T element, int index){
        checkIndex(index);
        if(size >= arr.length){
            increaseBuffer();
        }
        for(int i = size; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        size++;
    }

    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    public T getElement(int index){
        checkIndex(index);
        return arr[index];
    }

    public int getSize(){
        return size;
    }

    public void removeElement(int index){
        checkIndex(index);
        for(int i = index + 1; i < size; i++){
            arr[i - 1] = arr[i];
        }
        size--;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("Index not correct");
        }
    }

    public void clear(){
        arr = (T[]) new Object[5];
        size = 0;
    }

    public MyIterator<T> iterator() {
        return new MyArrayListIterator<>();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void add(int i, T last) {

    }

    private class MyArrayListIterator<E> implements MyIterator<E> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex < size;
        }

        public E next() {
            if (!hasNext()) {
                throw new ArrayIndexOutOfBoundsException("No more elements");
            }
            return (E) arr[currentIndex++];
        }
    }
}