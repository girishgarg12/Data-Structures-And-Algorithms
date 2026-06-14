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
    public int pairSum(ListNode head) {
        ListNode curr = head, twin = head;
        int n=0;
        while(curr != null){
            n++;
            curr = curr.next;
        }
        if(n == 2) return head.val + head.next.val;
        curr = head;
        ListNode prev = null;
        for(int i=0;i<n/2;i++){
            prev = twin;
            twin = twin.next;
        }
        while(twin!=null){
            ListNode next = twin.next;
            twin.next = prev;
            prev = twin;
            twin = next;
        }
        int res = 0;
        twin = prev;
        while(twin.next != curr){
            int s = curr.val + twin.val;
            res = Math.max(res,s);
            curr = curr.next;
            twin = twin.next;
        }
        res = Math.max(curr.val + twin.val , res);
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna