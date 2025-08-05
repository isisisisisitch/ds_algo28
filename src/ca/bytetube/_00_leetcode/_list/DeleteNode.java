package ca.bytetube._00_leetcode._list;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * @author dall.
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
