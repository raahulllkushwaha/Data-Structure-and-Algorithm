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
    public ListNode reverse(ListNode head, int times){
        ListNode curr = head;
        ListNode prev = null;
        while(times > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            times--;    
        }
        return prev;
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right;
        ListNode res = null;
        ListNode prevLeft = null;
        int size = 2;
        while (left != null){
            right = left;

            for(int i = 0; i < size - 1; i++){
                if(right == null){
                    break;
                }
                right = right.next;
            }
            if(right != null){
                ListNode nextLeft = right.next;
                reverse(left, size);

               
                if(res == null){
                    res = right;
                }
                
                if (prevLeft != null) {
                    prevLeft.next = right; 
                }
                left.next = nextLeft; 
                prevLeft = left;
                left = nextLeft;
            }
               else {
                
                if (prevLeft != null) {
                    prevLeft.next = left;
                }
                break; 
            }
        }
        return res != null ? res : head;
    }
}