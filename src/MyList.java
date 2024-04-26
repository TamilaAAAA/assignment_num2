interface MyList<T> {
    void addElement(T element);
    void addElement(T element, int index);
    T getElement(int index);
    int getSize();
    void removeElement(int index);
    void clear();
    MyIterator<T> iterator();

    boolean isEmpty();

    void add(int i, T last);
}