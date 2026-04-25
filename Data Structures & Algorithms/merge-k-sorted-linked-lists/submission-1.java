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
        if(lists.length < 1) return null;
        if(lists.length == 1) return lists[0];

        while(lists.length > 1){
            List<ListNode> mergedLists = new ArrayList<>();

            for(int i = 0; i < lists.length; i+=2){
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i+1]: null; 
                mergedLists.add(merge(l1,l2));
            }

            lists = mergedLists.toArray(new ListNode[0]);
        }

        return lists[0];
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
