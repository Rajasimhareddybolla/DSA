package stack_quee;

 public class stack {
    char [] arr ;
    int size ;
    int capacity ;
    public  stack(int capacity){
        this.capacity = capacity;
        this.arr = new char[capacity];
        this.size = 0 ;
    }
    private boolean recreate(){
        if (this.size >= 0.666*this.capacity){
            char arr_n[] = new char[this.capacity*2];
            for (int i = 0 ; i <this.size ; i++){
                arr_n[i] = arr[i];
            }
            this.arr = arr_n;
            this.capacity *= 2;
            return true;
        }
        return false;
    }
    public void add(char c){
        this.arr[this.size+1] = c;
        this.size ++;
        if(recreate()){
            System.out.println("created an new array");
        }
    }
    public char pop(){
        return this.arr[this.size--];
    }
}