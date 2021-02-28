package heap;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 *
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数（所有数值排序之后位于中间的数值）。
 */
public class Solution {

    // 小堆 存放大于中位数的元素
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // 大堆 存放小于中位数的元素 (奇数时包含中位数)
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    /** initialize your data structure here. */
    public Solution() {

    }

    public void addNum(int num) {

        // 先按大小插入，再调整
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {// 小于大堆的第一个元素
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return new Double(maxHeap.peek());
        } else {
            return new Double(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}