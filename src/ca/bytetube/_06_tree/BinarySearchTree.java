package ca.bytetube._06_tree;

import java.util.Comparator;

//BinarySearchTree<Integer>
public class BinarySearchTree<E> extends BinaryTree<E> {
    private Comparator<E> comparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void add(E element) {
        if (element == null) throw new RuntimeException("element can not be null !");
        //1.add first node
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        //2.add not first node
        Node<E> node = root;
        int cmp = 0;
        Node<E> parent = root;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) node = node.right;
            else if (cmp < 0) node = node.left;
            else {
                node.element = element;
                return;
            }
        }
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) parent.right = newNode;
        else parent.left = newNode;
        size++;
    }

    private int compare(E e1, E e2) {
        if (comparator != null) return comparator.compare(e1, e2);
        return ((Comparable<E>) e1).compareTo(e2);

    }

    private Node<E> node(E element) {
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);

            if (cmp > 0) node = node.right;
            else if (cmp < 0) node = node.left;
            else {

                return node;
            }
        }

        return null;
    }

    @Override
    public void remove(E element) {
        if (element == null) throw new RuntimeException("element can not be null !");
        remove(node(element));

    }

    private void remove(Node<E> node) {
        size--;
        //Delete node with degree 2
        if (node.left != null && node.right != null) {
            Node<E> s = successor(node);
            node.element = s.element;
            node = s;

        }

        //Delete node with degree 1
        Node<E> replacement = node.left != null ? node.left : node.right;
        if (replacement != null) {
            replacement.parent = node.parent;
            if (node == root) root = replacement;
            else {
                if (node == node.parent.left) node.parent.left = replacement;
                else node.parent.right = replacement;
            }
        }


        //Delete node with degree 0
        else if (node.parent == null) root = null;
        else {
            if (node == node.parent.left) node.parent.left = null;
            else node.parent.right = null;
        }

    }


    @Override
    public boolean contains(E element) {
        return false;
    }
}
