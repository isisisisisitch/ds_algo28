package ca.bytetube._02_dynamicarray;

public class ArrayList<E> {
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        // this.size = 0;
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    // Number of elements
    public int size() {
        return size;
    }

    // Is it empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Clear all the elements
    void clear() {
        //elements = null;
        size = 0;
    }


    // Add elements to the end
    void add(E element) {
        add(size - 1, element);
    }

    // Add elements to the index position
    void add(int index, E element) {

    }

    // Returns the element corresponding to the index position
    public E get(int index) {
        //todo
        return elements[index];
    }

    // Set the element at the index position
    E set(int index, E element) {
        return null;
    }


    // Delete elements to the index position
    E remove(int index) {
        return null;
    }


    // Return the index of the element
    int indexOf(E element) {
        return 0;
    }


    //Contains a certain element
    boolean contains(E element) {
        return false;
    }
}
