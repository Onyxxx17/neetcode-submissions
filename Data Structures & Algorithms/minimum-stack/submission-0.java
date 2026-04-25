class MinStack {

    private Stack<Integer> normal;
    private Stack<Integer> min;
    public MinStack() {
        normal = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        normal.push(val);
        if(min.isEmpty() || val <= min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        int i = normal.pop();
        if(min.peek() == i){
            min.pop();
        }
    }
    
    public int top() {
        return normal.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
