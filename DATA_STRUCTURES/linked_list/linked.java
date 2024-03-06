class Linked_list{
    protected int size ;
    protected int[] arr;
    public Linked_list(int sie,int []arre){
        this.arr = new int[sie];
        this.arr = arre;
    }
    public int get_size(){
        return this.size ;
    }
    public int[] get_arr(){
        return this.arr;
    }
    public boolean set_size(int size){
        if (this.size >= size ){
            this.size = size ;
            return true;
        }
        return false;
    }
    public boolean set_arr(int[] arr , int size){
        this.arr = arr;
        this.size = size;
        return true;
    }
}
public class linked {
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        Linked_list link = new Linked_list(3,arr);
        arr = link.get_arr();
        for (int x:arr){
            System.out.println(x);
        }
    }
}