package ca.bytetube._03_linkedlist.doubly;

import ca.bytetube._03_linkedlist.AbstractList;

public class DoublyCircularLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;


    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    private Node<E> node(int index) {
        Node<E> node;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }

        }

        return node;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> oldNode = node(index);
        E oldElement = oldNode.element;
        oldNode.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        //tail/first Node
        if (index == size) {
            Node<E> oldLast = last;
            Node<E> newLast = new Node<>(element, oldLast, first);
            last = newLast;
            if (size == 0) {
                first = newLast;
                newLast.next = newLast;
                newLast.prev = newLast;
            } else {
                oldLast.next = newLast;
                first.prev = last;
            }
        } else {
            //common/head
            Node<E> nextNode = node(index);
            Node<E> prevNode = nextNode.prev;
            Node<E> newNode = new Node<>(element, prevNode, nextNode);
            nextNode.prev = newNode;
            prevNode.next = newNode;
            if (index == 0) first = newNode;
        }
        size++;
    }


    @Override
    public E remove(int index) {
        Node<E> node = node(index);
        Node<E> prevNode = node.prev;
        Node<E> nextNode = node.next;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            if (index == 0) {
                first = nextNode;
                last.next = nextNode;
            } else {
                prevNode.next = nextNode;
            }

            if (index == size - 1) {
                last = prevNode;
                first.prev = prevNode;
            } else {
                nextNode.prev = prevNode;
            }
        }
        size--;
        return node.element;
    }


    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;


        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
