package bak.me;

import java.util.PriorityQueue;

/**
 * 优先级队列 实现中位数
 */
public class MedianSolution {

    // 小堆 存放大于中位数的元素
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // 大堆 存放小于中位数的元素
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    // 保证 maxHeap 和 minHeap 元素个数一样多，或仅多一个
    public void insert(Integer num) {

        // 先按大小插入，再调整
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {// 小于大堆的第一个元素
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.peek());
            minHeap.poll();
        } else if (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.offer(maxHeap.peek());
            maxHeap.poll();
        }
    }

    public Double getMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return new Double(maxHeap.peek());
        } else {
            return new Double(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{10, 1, 3, 7, 6, 4, 9, 5, 2, 8};

        MedianSolution medianSolution = new MedianSolution();

        for (int i = 0; i < arr.length; i++) {
            medianSolution.insert(arr[i]);
        }

        System.out.println(medianSolution.getMedian());

        System.out.println("++++++++++++++++++++++++++++++++++++++++");

    }
}