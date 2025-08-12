package ca.bytetube._04_stack;

public abstract class AbstractList<E> implements List<E> {
    public int size;
    public static final int ELEMENT_NOT_FOUND = -1;


    // Number of elements
    public int size() {
        return size;
    }

    //     Is it empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Add elements to the end
    public void add(E element) {
        add(size, element);
    }

    //Contains a certain element
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    public void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) outOfBounds(index);
    }

    public void rangeCheck(int index) {
        if (index < 0 || index >= size) outOfBounds(index);
    }

    public void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("index " + index + " is outOfBounds");
    }

}
