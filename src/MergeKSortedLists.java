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

// Merge each list iteratively
// TC: O(m*n) n= length of lists. m = length of each linked list
// SC: O(1)
class MergeKSortedLists {
    ListNode head = new ListNode(Integer.MIN_VALUE);
    public ListNode mergeKLists(ListNode[] lists) {
        for(ListNode list : lists) {
            merge(head,list);
        }
        return head.next;
    }
    private void merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while(node1!= null && node2!= null) {
            if(node1.val<= node2.val) {
                dummy.next = node1;
                node1 = node1.next;
            } else{
                dummy.next = node2;
                node2 = node2.next;
            }
            dummy = dummy.next;
        }

        if(node1 == null) {
            dummy.next = node2;
        }
        if(node2 == null) {
            dummy.next = node1;
        }
    }
}




// Maintain a min-heap with all of the heads of Linked lists initially.
// When the heap is not empty, remove the min element. And from whichever linked list I got min, add the next elemt to heap
// TC - O(nlogk)
// SC - O(n) n-size of lists
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode head:lists){
            if(head!= null)
                pq.add(head);
        }
        // while(!pq.isEmpty()) {
        //     System.out.println(pq.poll().val);
        // }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        while(!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;
            if(minNode.next!= null) {
                pq.add(minNode.next);
            }
        }
        return dummy.next;
    }
}