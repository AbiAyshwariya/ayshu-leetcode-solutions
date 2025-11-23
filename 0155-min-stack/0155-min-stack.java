class Pair{
    int ele1;
    int ele2;
    Pair(int ele1,int ele2){
        this.ele1=ele1;
        this.ele2=ele2;
    }
}

class MinStack {
    Stack<Pair> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        int min;
        if(st.isEmpty()){
            min=val;
        }
        else{
           min=Math.min(st.peek().ele2, val);
        }
        st.push(new Pair(val,min));
    }

    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
        }
    }
    
    public int top() {
        if(!st.isEmpty()){
            return st.peek().ele1;
        }
        else{
            return 0;
        }
    }
    
    public int getMin() {
        return st.peek().ele2;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */