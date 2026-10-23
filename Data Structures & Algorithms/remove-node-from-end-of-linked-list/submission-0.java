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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rHead1 = reverseList(head);
        ListNode rHead2 = rHead1;
        ListNode prev = null;

        int i = 1;
        while(rHead1 != null) {
            if(i == n) {
                if(prev != null) {
                    prev.next = rHead1.next;
                    return reverseList(rHead2);
                }
                else {
                    return reverseList(rHead2.next);
                }
            }
            prev = rHead1;
            rHead1 = rHead1.next;
            i++;
        }

        return reverseList(rHead2);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while(head != null) {
            ListNode nxt = head.next;
            head.next = prev;
            prev = head;
            head = nxt;
        }

        return prev;
    }
}
