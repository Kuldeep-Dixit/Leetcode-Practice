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
    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;

        // ListNode curr = head, next = curr;
        // while(next != null){
        //     if(curr.val == next.val){
        //         while(next != null && next.val == curr.val ) next = next.next;
        //     }
        //     curr.next = next;
        //     curr = curr.next;
        // }
        // if(curr != null && curr.next != null)curr.next = null;
        // return head;
    }

}