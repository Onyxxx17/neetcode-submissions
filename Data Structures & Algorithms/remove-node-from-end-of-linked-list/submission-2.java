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

        if(head.next == null) return null;
        ListNode node = head;
        int size = 0;
        while(node != null){
            node = node.next;
            size++;
        }

        int remove = size - n;
        ListNode prev = null;
        ListNode current = head;
        int i = 0;
        while(current != null){
            if(i == remove){
                if(prev == null){
                    head = head.next;
                    return head;
                } else{
                    prev.next = current.next;
                }
            }
            prev = current;
            current = current.next;
            i++;
        }
        return head;
    }
}
