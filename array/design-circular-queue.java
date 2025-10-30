class MyCircularQueue {
    private int[] data;    // Array to store queue elements
    private int head;      // Points to the current front element
    private int tail;      // Points to the next insertion position (rear + 1)
    private int size;      // Number of elements currently in the queue
    private int capacity;  // Maximum number of elements (k)

    // Constructor: initialize the circular queue with capacity k
    public MyCircularQueue(int k) {
        capacity = k;
        data = new int[k];
        head = 0;
        tail = 0;
        size = 0;
    }

    // Insert an element into the circular queue.
    // Return true if the operation is successful.
    public boolean enQueue(int value) {
        if (isFull()) return false;
        data[tail] = value;
        tail = (tail + 1) % capacity; // Move tail forward circularly
        size++;
        return true;
    }

    // Delete an element from the front of the circular queue.
    // Return true if the operation is successful.
    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % capacity; // Move head forward circularly
        size--;
        return true;
    }

    // Get the front item from the queue.
    // Return -1 if the queue is empty.
    public int Front() {
        if (isEmpty()) return -1;
        return data[head];
    }

    // Get the last item (rear) from the queue.
    // Return -1 if the queue is empty.
    public int Rear() {
        if (isEmpty()) return -1;
        // (tail - 1 + capacity) ensures positive index when tail = 0
        return data[(tail - 1 + capacity) % capacity];
    }

    // Check whether the circular queue is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    // Check whether the circular queue is full.
    public boolean isFull() {
        return size == capacity;
    }
}
