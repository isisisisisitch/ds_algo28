package ca.bytetube._03_linkedlist.singly;

import ca.bytetube._03_linkedlist.AbstractList;

public class SinglyLinkedList<E> extends AbstractList<E> {
    Node<E> first;

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    private Node<E> node(int index) {
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //head
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            //tail
            Node<E> prevNode = node(index - 1);//3
            // "="
            // int i = 10;===>assign(from right to left)
            // prevNode.next = newNode; ===> point to (from left to right)
            prevNode.next = new Node<>(element, prevNode.next);
        }

        size++;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return node(index).element;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> removed = first;
        if (index == 0) {
            first = first.next;
        } else {
            //tail
            Node<E> prevNode = node(index - 1);
            removed = prevNode.next;
            prevNode.next = removed.next;
        }

        size--;
        return removed.element;
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
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
