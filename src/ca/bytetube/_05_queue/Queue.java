package ca.bytetube._05_queue;

import ca.bytetube._05_queue.doubly.LinkedList;

public class Queue<E> {
    private LinkedList<E> linkedList;

    public Queue() {
        this.linkedList = new LinkedList<>();
    }

    // Number of elements
    public int size() {
        return linkedList.size();
    }

    // Is it empty
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }


    // Clear elements
    public void clear() {
        linkedList.clear();
    }

    //enQueue
    public void enQueue(E element) {
        linkedList.add(element);
    }

    // deQueue
    public E deQueue() {
        return linkedList.remove(0);
    }

    //Get the head element of  the queue
    public E front() {
        return linkedList.get(0);
    }


}
