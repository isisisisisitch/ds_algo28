package ca.bytetube._06_tree;


import ca.bytetube._06_tree.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public abstract class BinaryTree<E> implements BinaryTreeInfo {
    protected Node<E> root;
    protected int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public abstract void add(E element);

    public abstract void remove(E element);

    public abstract boolean contains(E element);

    public void preOrderTraversal() {
        preOrderTraversal0(root);
    }

    public void preOrderTraversal0(Node<E> node) {
        if (node == null) return;
        System.out.print(node.element + " ");
        preOrderTraversal0(node.left);
        preOrderTraversal0(node.right);

    }

    public void preOrderTraversal(Node<E> node) {
        if (node == null) return;
        Stack<Node<E>> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node<E> pop = stack.pop();
            System.out.print(pop + " ");
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }

    }

    public void InOrderTraversal0(Node<E> node) {
        if (node == null) return;

        InOrderTraversal0(node.left);
        System.out.print(node.element + " ");
        InOrderTraversal0(node.right);

    }

    public void inOrderTraversal(Node<E> node) {

        if (node != null) {
            Stack<Node<E>> stack = new Stack<>();
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    Node<E> pop = stack.pop();
                    System.out.print(pop.element + " ");
                    node = pop.right;
                }

            }
        }


    }

    public void postOrderTraversal0(Node<E> node) {
        if (node == null) return;
        postOrderTraversal0(node.left);
        postOrderTraversal0(node.right);
        System.out.print(node.element + " ");

    }

    public void postOrderTraversal(Node<E> node) {
        if (node == null) return;
        Stack<Node<E>> stack = new Stack<>();
        Stack<Node<E>> helpStack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node<E> pop = stack.pop();
            helpStack.push(pop);
            if (pop.left != null) stack.push(pop.left);
            if (pop.right != null) stack.push(pop.right);

        }

        while (!helpStack.isEmpty()) {
            System.out.print(helpStack.pop().element + " ");
        }

    }

    public void levelOrderTraversal(Node<E> node) {
        if (node == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            System.out.print(poll.element + " ");
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }


    }

    public int height0() {
        return height0(root);
    }

    private int height0(Node<E> node) {
        if (node == null) return 0;
        return Math.max(height0(node.left), height0(node.right)) + 1;

    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        Queue<Node<E>> queue = new LinkedList<>();
        int height = 0;
        queue.offer(node);
        int levelSize = 1;

        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            levelSize--;

            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
            if (levelSize == 0) {
                height++;
                levelSize = queue.size();
            }
        }


        return height;

    }

    public boolean isCBT(Node<E> node) {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            if (isLeaf && !(poll.left == null && poll.right == null)) return false;
            //If node.left!=null && node.right!=null,add node.left and node.right to the queue in sequence
            if (poll.left != null && poll.right != null) {
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
            //If node.left==null && node.right!=null，return false
            else if (poll.left == null && poll.right != null) return false;

                //If node.left!=null && node.right==null
            else if (poll.left != null && poll.right == null) {
                queue.offer(poll.left);
                isLeaf = true;
            } else {//node.left==null && node.right==null
                isLeaf = true;
            }
        }

        return true;
    }

    protected Node<E> predecessor(Node<E> node) {
        if (node == null) return null;
        //1.node.left != null
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) p = p.right;
            return p;
        }
        //2.node.left == null && node.parent != null
        while (node.parent != null && node == node.parent.left) node = node.parent;
        return node.parent;
    }

    protected Node<E> successor(Node<E> node) {
        if (node == null) return null;
        //1.node.right != null
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) p = p.left;
            return p;
        }
        //2.node.right == null && node.parent != null
        while (node.parent != null && node == node.parent.right) node = node.parent;
        return node.parent;
    }

    public static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;


        public Node() {
        }

        public Node(E element) {
            this.element = element;

        }

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }


        @Override
        public String toString() {
            return "element=" + element;
        }
    }


    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>) node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }

        return myNode.element + "_p(" + parentString + ")";
    }


}
