
class a_quee{
    private int read =0;
    private int write =0;
    int size =0;
    int capacity;
    int [] aray;
    public a_quee(int len){
        this.aray = new int[len];
        this.capacity = len;
    }
    public a_quee(int arr[]){
        this.aray = arr.clone();
        this.capacity = arr.length;
        this.size  = arr.length;
    }
        /**
     * @return int read return the 
     */
    public int get_read() {
        return this.read;
    }

    /**
     * @param  the  to set
     */
    public void set_read( ) {
        if (this.capacity-1 == this.read){
            this.read =0;
        }
        else{
            this.size --;
            this.read++;
        }  
    }

    /**
     * @return int write return the 
     */
    public int  get_write() {
        return this.write;
    }

    /**
     * @param  the  to set
     */
    public void increment_write() { // i used to overwrite if the array is full to write
        
        if (this.capacity-1 == this.write){
            this.write =0;
        }
        else{
            this.size ++;
            this.write++;
        }
    }    
}
class operations_a{
    a_quee quee;
    public operations_a(a_quee arr){
        this.quee = arr;
    }
    public void enquee(int value){
    
        this.quee.aray[this.quee.get_write()] = value;
        this.quee.increment_write();
    }
    public int dequee(){
        int value = this.quee.aray[this.quee.get_read()];
        this.quee.aray[this.quee.get_read()]  = 0;
        this.quee.set_read();
        return value;
    }
    public int space(){
        return this.quee.capacity - (this.quee.size+1);
    }
    public boolean empty(){
        return this.quee.size >0;
    }
}
public class quee_array {
    public static void main(String[] args) {
        a_quee arr = new a_quee(5);
        operations_a op  = new operations_a(arr);
        op.enquee(533336);
        op.enquee(5644434);
        op.enquee(5655);
        op.enquee(567);
        op.enquee(87);
        op.enquee(87);
        op.dequee();
        op.enquee(89);
    }   
}
// int[] arr = {1,2,3};
// int [] arr2 = arr.clone(); // it is deep copyt
// arr[2] = 90;
// for (int a:arr2){
//     System.out.println(a);    gives 1,2,3
// 