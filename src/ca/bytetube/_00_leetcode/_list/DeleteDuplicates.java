package ca.bytetube._00_leetcode._list;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author dall.
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < 50; i++) {
            set.add(i);
        }
        System.out.println(set);

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) node.next = node.next.next;
            else node = node.next;
        }

        return head;
    }
}
