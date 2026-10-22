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
    public void reorderList(ListNode head) {
        ListNode half = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            half = half.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while(half != null) { 
            ListNode nxt = half.next;   
            half.next = prev;
            prev = half;
            half = nxt;
        }

        ListNode first = head;
        ListNode second = prev;

        while (second.next != null) {
            ListNode n1 = first.next;
            ListNode n2 = second.next;

            first.next = second;
            second.next = n1;

            first = n1;
            second = n2;
        }
    }
}
