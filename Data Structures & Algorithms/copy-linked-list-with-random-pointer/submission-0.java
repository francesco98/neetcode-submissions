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
        Map<Node, Node> nodeCopy = new HashMap<>();

        for(Node curr = head; curr != null; curr = curr.next) {
            nodeCopy.put(curr, new Node(curr.val));
        }

        Node deepCopy = new Node(0);
        Node dummyCopyHead = deepCopy;

        for(Node curr = head; curr != null; curr = curr.next) {
            deepCopy.next = nodeCopy.get(curr);
            deepCopy.next.random = nodeCopy.get(curr.random);
            deepCopy = deepCopy.next;
        }

        return dummyCopyHead.next;
    }
}
