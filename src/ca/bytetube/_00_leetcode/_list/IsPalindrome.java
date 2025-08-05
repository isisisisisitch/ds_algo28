package ca.bytetube._00_leetcode._list;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 *
 * @author dall.
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode midNode = midNode(head);
        ListNode rightHead = reverseList(midNode.next);
        ListNode left = head;
        ListNode right = rightHead;
        while (left != null && right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    private ListNode midNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
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
}
