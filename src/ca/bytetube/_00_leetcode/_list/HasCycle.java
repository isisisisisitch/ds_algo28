package ca.bytetube._00_leetcode._list;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * @author dall.
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }


        return false;
    }
}
