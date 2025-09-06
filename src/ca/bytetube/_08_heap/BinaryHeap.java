package ca.bytetube._08_heap;

import ca.bytetube._08_heap.printer.BinaryTreeInfo;

import java.util.Comparator;

public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(Comparator<E> comparator, E[] elements) {
        super(comparator);
        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            size = elements.length;
            int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                this.elements[i] = elements[i];
            }
        }

        heapify();
    }

    private void heapify() {
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    public BinaryHeap(Comparator<E> comparator) {
        super(comparator);
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap() {
        // this.size = 0;
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);

    }

    @Override
    public E remove() {
        E element = elements[0];
        int lastIndex = --size;
//        1. Cover the root node with the last node
//        2. Delete the last node
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        siftDown(0);


        return element;
    }

    @Override
    public E get() {
        return elements[0];
    }

    @Override
    public E replace(E element) {
        elementNotNullCheck(element);
        E root = null;
        if (size == 0) {
            root = element;
            size++;
        } else {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }


        return root;
    }

    //Loop the following（80 is referred to as node for short）
    //If node ＞ parent node
    //Swap with parent node

    private void siftUp(int index) {
        E e = elements[index];
        while (index > 0) {
            int parentIndex = (index - 1) >> 1;
            E parent = elements[parentIndex];
            //If node ≤ parent node，or node has not parent node
            //Exit the loop
            if (compare(e, parent) <= 0) break;
            //If node ＞ parent node
            elements[index] = parent;
            index = parentIndex;

        }

        elements[index] = e;
    }

    private void elementNotNullCheck(E element) {
        if (element == null) throw new IllegalArgumentException("element can not be null !");
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) newElements[i] = elements[i];
        elements = newElements;
    }


    //3. Loop the following（43 is referred to as node for short）
    //If node < the maximum child node
    //Swap with the maximum child node
    //If node ≥ the maximum child node， or node has not child node
    //Exit the loop
    private void siftDown(int index) {
        E element = elements[index];
        int half = size >> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;

            int rightChildIndex = childIndex + 1;
            E child = elements[childIndex];
            if (rightChildIndex < size && compare(elements[rightChildIndex], child) > 0) {
                child = elements[childIndex = rightChildIndex];
            }

            if (compare(element, child) >= 0) break;
            elements[index] = child;
            index = childIndex;


        }

        elements[index] = element;


    }


    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        int index = ((int) node << 1) + 1;
        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        int index = ((int) node << 1) + 2;
        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {
        return elements[(int) node];
    }
}
