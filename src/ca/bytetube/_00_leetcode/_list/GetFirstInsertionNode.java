package ca.bytetube._00_leetcode._list;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer. The node that tail's next pointer is connected to is called cycle node.
 * You need to return the cycle node.

 * Returns the intersection node of two acyclic singly linked lists

 * Returns the intersection node of two cycle singly linked lists
 */
public class GetFirstInsertionNode {
    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6

        System.out.println(getFirstIntersectionNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        // int value = getFirstIntersectionNode(head1, head2).value;
        // System.out.println(value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        int value = getFirstIntersectionNode(head1, head2).value;
        System.out.println(value);
    }

    public static Node getFirstIntersectionNode(Node head1, Node head2) {
        Node cycleNode1 = getCycleNode(head1);
        Node cycleNode2 = getCycleNode(head2);
        if (cycleNode1 == null && cycleNode2 == null) return getIntersectionNode(head1, head2);
        if (cycleNode1 != null && cycleNode2 != null) {
            return getCycleIntersectionNode(head1, cycleNode1, head2, cycleNode2);
        }
        return null;
    }


    public static Node getCycleIntersectionNode(Node head1, Node cycleNode1, Node head2, Node cycleNode2) {
        Node cur1 = null;
        Node cur2 = null;
        if (cycleNode1 == cycleNode2) {//II
            cur1 = head1;
            cur2 = head2;
            int diff = 0;
            while (cur1.next != cycleNode1) {
                diff++;
                cur1 = cur1.next;
            }

            while (cur2.next != cycleNode2) {
                diff--;
                cur2 = cur2.next;
            }
            cur1 = diff > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            diff = Math.abs(diff);
            while (diff != 0) {
                diff--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;

        } else {
            cur1 = cycleNode1.next;
            while (cur1 != cycleNode1) {
                if (cur1 == cycleNode2) {
                    //III
                    return cycleNode1;
                }
                cur1 = cur1.next;
            }

            return null;//I

        }


    }

    public static Node getIntersectionNode(Node head1, Node head2) {
        Node cur1 = head1;
        Node cur2 = head2;
        int diff = 0;
        while (cur1.next != null) {
            diff++;
            cur1 = cur1.next;
        }

        while (cur2.next != null) {
            diff--;
            cur2 = cur2.next;
        }

        cur1 = diff > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        diff = Math.abs(diff);

        while (diff != 0) {
            diff--;
            cur1 = cur1.next;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    public static Node getCycleNode(Node head) {
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
