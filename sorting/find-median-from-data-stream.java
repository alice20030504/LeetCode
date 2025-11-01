import java.util.*;

class MedianFinder {

    private PriorityQueue<Integer> maxHeap;  // lower half
    private PriorityQueue<Integer> minHeap;  // upper half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: always push into maxHeap first
        maxHeap.offer(num);

        // Step 2: move top of maxHeap to minHeap to maintain order property
        minHeap.offer(maxHeap.poll());

        // Step 3: ensure size condition (maxHeap >= minHeap)
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
