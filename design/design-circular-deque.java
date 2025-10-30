// This implementation uses a circular array and modular arithmetic (% capacity) to make both ends connect logically:
// When head moves left past index 0 → it wraps around to capacity - 1.
// When tail moves right past capacity - 1 → it wraps around to 0.
// Hence, both front and rear insertions/deletions can be done in O(1) time.

class MyCircularDeque {
    private int[] data;    // Array to store elements
    private int head;      // Points to the current front index
    private int tail;      // Points to the next insertion index at rear
    private int size;      // Current number of elements
    private int capacity;  // Maximum capacity

    // Constructor: Initialize the deque with capacity k
    public MyCircularDeque(int k) {
        capacity = k;
        data = new int[k];
        head = 0;
        tail = 0;
        size = 0;
    }

    // Adds an item at the front of Deque. Returns true if successful.
    public boolean insertFront(int value) {
        if (isFull()) return false;
        // Move head backward circularly
        head = (head - 1 + capacity) % capacity;
        data[head] = value;
        size++;
        return true;
    }

    // Adds an item at the rear of Deque. Returns true if successful.
    public boolean insertLast(int value) {
        if (isFull()) return false;
        data[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    // Deletes an item from the front. Returns true if successful.
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    // Deletes an item from the rear. Returns true if successful.
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = (tail - 1 + capacity) % capacity;
        size--;
        return true;
    }

    // Gets the front item. Returns -1 if deque is empty.
    public int getFront() {
        if (isEmpty()) return -1;
        return data[head];
    }

    // Gets the last item. Returns -1 if deque is empty.
    public int getRear() {
        if (isEmpty()) return -1;
        return data[(tail - 1 + capacity) % capacity];
    }

    // Checks whether the deque is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    // Checks whether the deque is full.
    public boolean isFull() {
        return size == capacity;
    }
}
