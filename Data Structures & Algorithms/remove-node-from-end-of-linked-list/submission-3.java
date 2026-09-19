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
        //Get the size of linked list
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        int index = size - n + 1;
        int k = 1;

        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            if(k == index){
                if(prev == null){
                    head = head.next;
                    return head;
                }
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
            k++;
        }

        return head;
    }
}
