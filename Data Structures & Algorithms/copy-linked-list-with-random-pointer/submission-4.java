/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        // A -> A' -> B -> B' -> ...
        for(Node curr = head ; curr != null ; curr = curr.next.next) {
            Node copy = new Node(curr.val);
            Node nxt = curr.next;
            curr.next = copy;
            copy.next = nxt;
        }

        for(Node curr = head; curr != null; curr = curr.next.next) {
            Node copy = curr.next;
            copy.random = curr.random == null ? null : curr.random.next;
        }

        final Node copyHead = head.next;

        for(Node curr = head; curr != null; curr = curr.next) {
            Node copy = curr.next;
            curr.next = copy.next;
            copy.next = copy.next == null ? null : copy.next.next;
        }

        return copyHead;
    }
}
