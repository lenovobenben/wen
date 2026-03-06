package heap;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 */
public class Solution2 {

    /**
     * 小顶堆，维持 k 个最大值
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }
}
