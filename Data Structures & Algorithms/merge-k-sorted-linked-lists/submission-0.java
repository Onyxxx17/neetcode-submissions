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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length <= 1) return null;
        for(int i = 1; i < lists.length; i++){
            lists[i] = merge(lists[i], lists[i-1]);
        }
        return lists[lists.length - 1];
    }

    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else{
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }

        while(list1 != null){
            current.next = list1;
            current = current.next;
            list1 = list1.next;
        }

        while(list2 != null){
            current.next = list2;
            current = current.next;
            list2 = list2.next;
        }

        return dummy.next;
    }
}
