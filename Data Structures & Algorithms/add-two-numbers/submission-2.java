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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        int carry = 0;

        while(l1 != null || l2 != null){
            int first = l1 != null ? l1.val : 0;
            int second = l2 != null ? l2.val : 0;

            int total = first + second + carry;
            carry = total / 10;
            int curr = total % 10;

            dummy.next = new ListNode(curr);
            dummy = dummy.next;

            l1 = l1 != null? l1.next : null;
            l2 = l2 != null? l2.next : null;
        }

        if(carry == 1){
            dummy.next = new ListNode(1);
        }

        return res.next;
    }
}
