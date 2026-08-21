/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;

        while(head != null) {
            reverseHead = new ListNode(head.val, reverseHead);
            head = head.next;
        }

        return reverseHead;
    }
}
