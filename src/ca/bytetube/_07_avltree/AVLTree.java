package ca.bytetube._07_avltree;

import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree<E> {
    public AVLTree() {
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }

    @Override
    public void afterAdd(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                calculateHeight(node);
            } else {
                rebalance2(node);
                break;
            }
        }

    }

    @Override
    protected void afterRemove(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                calculateHeight(node);
            } else {
                rebalance2(node);
                //break;
            }
        }
    }

    private void calculateHeight(Node<E> node) {
        ((AVLNode<E>) node).calculateHeight();
    }

    private void rebalance(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>) grand).tallerChild();
        Node<E> node = ((AVLNode<E>) parent).tallerChild();
        if (parent.isLeftChild()) {//L
            if (node.isLeftChild()) {//L
                rightRotation(grand);
            } else {//R
                leftRotation(parent);
                rightRotation(grand);
            }
        } else {//R
            if (node.isLeftChild()) {//L
                rightRotation(parent);
                leftRotation(grand);
            } else {//R
                leftRotation(grand);

            }
        }

    }

    private void rebalance2(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>) grand).tallerChild();
        Node<E> node = ((AVLNode<E>) parent).tallerChild();
        if (parent.isLeftChild()) {//L
            if (node.isLeftChild()) {//L
                rotation(grand, node.left, node, node.right, parent, parent.right, grand, grand.right);
            } else {//R
                rotation(grand, parent.left, parent, node.left, node, node.right, grand, grand.right);
            }
        } else {//R
            if (node.isLeftChild()) {//L
                rotation(grand, grand.left, grand, node.left, node, node.right, parent, parent.right);
            } else {//R
                rotation(grand, grand.left, grand, parent.left, parent, node.left, node, node.right);

            }
        }

    }

    private void rotation(Node<E> r, Node<E> a, Node<E> b, Node<E> c, Node<E> d, Node<E> e, Node<E> f, Node<E> g) {
        d.parent = r.parent;
        if (r.isLeftChild()) r.parent.left = d;
        else if (r.isRightChild()) r.parent.right = d;
        else root = d;

        //a---b---c
        b.left = a;
        if (a != null) a.parent = b;
        b.right = c;
        if (c != null) c.parent = b;
        calculateHeight(b);

        //e---f---g
        f.left = e;
        if (e != null) e.parent = f;
        f.right = g;
        if (g != null) g.parent = f;
        calculateHeight(f);

        //b---d---f
        d.left = b;
        b.parent = d;
        d.right = f;
        f.parent = d;
        calculateHeight(d);

    }

    private void leftRotation(Node<E> grand) {
        Node<E> parent = grand.right;
        Node<E> child = parent.left;//T1
        grand.right = child;
        parent.left = grand;
        //update parentNode parent
        afterRotation(grand, parent, child);
    }

    private void rightRotation(Node<E> grand) {
        Node<E> parent = grand.left;
        Node<E> child = parent.right;//T2

        grand.left = child;
        parent.right = grand;

        afterRotation(grand, parent, child);
    }

    private void afterRotation(Node<E> grand, Node<E> parent, Node<E> child) {
        //update parentNode parent
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else {
            root = parent;
        }
        //update childNode parent
        if (child != null) {
            child.parent = grand;
        }
        // update grandNode parent
        grand.parent = parent;

        calculateHeight(grand);
        calculateHeight(parent);
    }

    private boolean isBalanced(Node<E> node) {
        return Math.abs(((AVLNode<E>) node).balanceFactor()) <= 1;
    }


    private static class AVLNode<E> extends Node<E> {
        int height = 1;

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            return leftHeight - rightHeight;
        }


        public void calculateHeight() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            height = Math.max(leftHeight, rightHeight) + 1;
        }


        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            if (leftHeight > rightHeight) return left;
            if (leftHeight < rightHeight) return right;
            return this.isLeftChild() ? left : right;
        }
    }

}
