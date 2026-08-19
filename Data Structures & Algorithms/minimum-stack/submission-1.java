class MinStack {
    final Deque<Integer> main = new ArrayDeque<>();
    final Deque<Integer> history = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        main.push(val);
        history.push(history.isEmpty() ? val : Math.min(val, history.peek()));
    }
    
    public void pop() {
        main.pop();
        history.pop();
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return history.peek();
    }
}
