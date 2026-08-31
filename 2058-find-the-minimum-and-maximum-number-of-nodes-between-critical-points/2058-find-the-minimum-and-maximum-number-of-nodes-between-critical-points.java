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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head, curr = head.next, next = head.next.next;
        if(next == null) return new int[]{-1, -1};
        int firstC = -1, currC = -1;
        int idx = 1;
        int min = -1, max = -1;
        while(next != null){
            if((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)){
                if(firstC != -1) {
                    max = idx - firstC;
                }
                if(firstC == -1) firstC = idx;
                if(currC != -1) {
                    min = (min == -1) ? idx - currC : Math.min(min, idx - currC);
                }
                currC = idx;
            }
            prev = curr;
            curr = next;
            next = next.next;
            idx++;
        }
        return new int[]{min, max};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna