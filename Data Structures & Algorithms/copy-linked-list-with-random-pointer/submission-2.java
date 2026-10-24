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
        final Node dummyCopyHead = new Node(0);
        final Map<Node, Node> nodeCopy = new HashMap<>();

        Node deepCopyCurr = dummyCopyHead;
        for(Node curr = head; curr != null; curr = curr.next) {
            nodeCopy.computeIfAbsent(curr, n -> new Node(n.val));
            if(curr.random != null)
                nodeCopy.computeIfAbsent(curr.random, n -> new Node(n.val));

            deepCopyCurr.next = nodeCopy.get(curr);
            deepCopyCurr.next.random = nodeCopy.get(curr.random);
            deepCopyCurr = deepCopyCurr.next;
        }

        return dummyCopyHead.next;
    }
}
