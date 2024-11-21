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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] parts = new ListNode[k];
        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        int partSize = length / k;
        int extraNodes = length % k;

        current = head;
        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            int currentPartSize = partSize + (i < extraNodes ? 1 : 0);
            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) {
                    current = current.next;
                }
            }
            if (current != null) {
                ListNode nextPartHead = current.next;
                current.next = null;
                current = nextPartHead;
            }
            parts[i] = partHead;
        }

        return parts;
    }
}