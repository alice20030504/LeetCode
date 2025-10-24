class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push element onto stack
    public void push(int val) {
        stack.push(val);
        // If minStack is empty or val <= current min, push it to minStack too
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Remove the top element
    public void pop() {
        int removed = stack.pop();
        // If the removed element is the current min, pop from minStack as well
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // Get the top element
    public int top() {
        return stack.peek();
    }

    // Retrieve the minimum element in O(1)
    public int getMin() {
        return minStack.peek();
    }
}
