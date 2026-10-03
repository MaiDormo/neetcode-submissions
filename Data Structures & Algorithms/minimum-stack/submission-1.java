class MinStack {

    Map<Integer, Integer> minMap;
    Deque<Integer> stack;
    int min;

    public MinStack() {
        this.minMap = new HashMap<>();
        this.stack = new ArrayDeque<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (stack.isEmpty()) min = Integer.MAX_VALUE;
        if (val < min) min = val;
        stack.push(val);
        minMap.put(stack.size(), min);
    }
    
    public void pop() {
        stack.pop();
        if (!stack.isEmpty()) {
            min = minMap.get(stack.size());
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minMap.get(stack.size());
    }
}
