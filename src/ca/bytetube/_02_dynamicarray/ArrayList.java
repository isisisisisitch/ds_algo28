package ca.bytetube._02_dynamicarray;

public class ArrayList<E> {
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

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
        add(size, element);
    }

    // Add elements to the index position
    void add(int index, E element) {//index = 0
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("index " + index + " is outOfBounds");
        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) newElements[i] = elements[i];
        elements = newElements;
    }

    // Returns the element corresponding to the index position
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }


    // Delete elements to the index position
    public E remove(int index) {
        rangeCheck(index);
        E oldElement = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return oldElement;
    }


    // Set the element at the index position
    public E set(int index, E element) {
        rangeCheck(index);
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    // Return the index of the element
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {//address(HashCode)
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {//value
                    return i;
                }
            }
        }

        return ELEMENT_NOT_FOUND;
    }


    //Contains a certain element
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) outOfBounds(index);
    }

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("index " + index + " is outOfBounds");
    }
}
