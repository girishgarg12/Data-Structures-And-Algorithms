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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        if(head.next==null) return head;
        int n=1;
        ListNode end=head;
        while(end.next!=null){
            n++;
            end=end.next;
        }
        k=k%n;
        if(k==0) return head;
        ListNode curr=head;
        ListNode next=head.next;
        for(int i=0;i<(n-k-1);i++){
            curr=curr.next;
            next=curr.next;
        }
        curr.next=null;
        end.next=head;
        head=next;
        return head;

    }
}