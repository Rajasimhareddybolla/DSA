class node {
    int data;
    node next;
    public boolean onDeleteMe;
    public node(int value,node next){
        this.data = value; // assign the value to the current data
        this.next = next; // assign for the null value
    }
    public node(int value){
        this(value,null);
    }
    public void insert_after(int value){
        next = new node(value,next); //hear without using extra memory we are doing this thing
        //node ne = new node(value);
        // this.next = ne;
        //be  causious about run time errors at the time of null point 
    }
    public void insert_after(int value[],int size){
        for (int i : value){
            this.insert_after(i);
        }
    }
    public void setValue(int k) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setValue'");
    }
    public node getNextNode() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNextNode'");
    }
    public int getValue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValue'");
    }
    public void setNextNode(node node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNextNode'");
    }
}
class operations{
    node header ;
    public operations(node header){
        this.header = header;
    }
    public node insert_before(node at_node,int value){
        node ptr = header;
        if (header == at_node){
            System.out.println("hello worldd");
            
            return new node(value,header);
        }
        while (true) {
            if(ptr.next == at_node){
                ptr.next = new node(value,ptr.next);
                break;
            }
            ptr = ptr.next;
        }
        return null;
    }
    public int find (int value){
        node ptr = header;
        int index = 1;
        while (ptr != null) {
            if(ptr.data == value)
                return index;
            ptr =ptr.next;
            index++;
        }
        return -999;
    }
    public int nth_item(int index){
        node ptr = header;
        if(index < 1)
            return -999;
        try{
        for ( int i = 1; i <index ; i++,ptr = ptr.next){

        }
        return ptr.data;
    } catch (Exception e) {
        System.out.println("list index out of range"+e);
        return -999;
    }
    }
}
public class linked_list {
    public static void main(String[] args) {
        node n1 = new node(1);
        node n2 = new node(2,n1);
        node n3 = new node(3,n2);
        node n4  =new node(4, n3);
        n4.insert_after(6);
        operations op = new operations(n4);
        node nw_header = op.insert_before(n4, 10);
        op.header = nw_header;

        System.out.println(op.nth_item(1));
    }
}
