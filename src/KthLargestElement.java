// Use min-heap of k elements and return the top element
// TC: O(n log k)
// SC: O(k)
import java.util.PriorityQueue;

class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++) {
            q.add(nums[i]);
            // System.out.println("Initial q");
            // System.out.println(q);
            if(q.size() > k) {
                q.poll();
            }
            // System.out.println("After q");
            // System.out.println(q);
        }
        return q.peek();
    }
}