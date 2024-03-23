package stack_quee;
import java.lang.Math;
class MinStack {
    int arr [];
    int size =0;
    MinStack min = new MinStack();
    public MinStack() {
        min.push((int)Math.pow(2,32));
        this.arr = new int [9];
    }
    
    public void push(int val) {
        this.arr[size ]  = val;
        if(val <this.min.top()){
            this.min.push(val);
        }
        this.size++;
    }
    
    public void pop() {
        this.size --;
        if (this.min.top() == this.top()){
            this.min.pop();
        }
        this.pop();
    }
    
    public int top() {
        if (this.arr != null){
            return this.arr[this.size-1];
        }
        return -1;
    }
    
    public int getMin() {
        return this.min.top();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:*/
public class min_stack{
    public static void main(String[] args) {
        int val = 90 ; 
        MinStack obj = new MinStack();
        obj.push(val);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
         
    }
}
