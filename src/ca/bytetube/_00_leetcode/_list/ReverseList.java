package ca.bytetube._00_leetcode._list;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * @author dall.
 */
public class ReverseList {

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }

        return newHead;
    }

    /**
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;

    }
}
