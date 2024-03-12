class node {
    private int data ; 
    private node prev ; 
    private node next ;
    private head head = null ;
    private node_operations operations = null;
    public node (int data , node prev  , node next){
        this.data  = data ;
        this.next = next;
        this.prev = prev ;

    }
    public node(){ // constructing serializer
        this.data = -999;
        this.next = this;
        this.prev = this;
        this.head = new head(this);
        this.operations = new node_operations(this);
    }
    // creates a new node which can be used for use
    public node(int value){
        this.data = value ; 
    }
    // add a data after any thing 
    public void add_after(int value , head head ){ // due to dobule way linked list we need to modify on the both directions the node to which we need to add and the node which is after the past node check this code .
        node newNode = new node(value,this,this.next);
        this.next.prev = newNode;
        this.next = newNode;
        head.setSize(head.getSize()+1);
    }
    // add before 
    public void add_before(int value,head head){
        node newNode = new node(value,this.prev , this);
        this.prev.next = newNode;
        this.prev = newNode;
        head.setSize(head.getSize()+1);
    
    }

    //getter and setters for every thing like inuilt class and other class
        /**
     * @return node_operations return the operations
     */
    public node_operations getOperations() {
        return operations;
    }

    /**
     * @param operations the operations to set
     */
    public void setOperations(node_operations operations) {
        this.operations = operations;
    }
    /**
     * @return int return the data
     */

    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        if(this.next == this)
            throw new IllegalAccessError("cant acess to serializer's data");
        
        else
            this.data = data;
    }

    /**
     * @return node return the prev
     */
    public node getPrev() {
        return prev;
    }

    /**
     * @param prev the prev to set
     */
    public void setPrev(node prev) {
        this.prev = prev;
    }

    /**
     * @return node return the next
     */
    public node getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(node next) {
        this.next = next;
    }
        /**
     * @return head return the head
     */
    public head getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(head head) {
        this.head = head;
    }
    
    // all operations should start from hear
    
    public boolean empty(){
        if(this.next == this )
            return true;
        
        return false;
    }
}
class node_operations{
    node serializer;
    public node_operations(node serializer){
        this.serializer = serializer ;
    }
    public boolean pop_front(){
        if(serializer.getHead().getSize() == 0){
            throw new IllegalAccessError("can't remove from an empty list");
        }
        serializer.getNext().getNext().setPrev(serializer);
        serializer.setNext(serializer.getNext().getNext());
        serializer.getHead().setSize(serializer.getHead().getSize()-1);
        return true;
    }
    public void print(){
        node ptr = serializer.getNext();
        while (ptr!= serializer) {
            System.out.println("element in the index :" + ptr.getData());
            ptr = ptr.getNext();
        } ;
    }
    // need further implementaion to erase data and to find data easily
    public boolean erase(int index){
        int size = serializer.getHead().getSize();
        node ptr = serializer.getNext();
        if(index >= size){
            System.out.println("cant get which having index > size "+serializer.getHead().getSize());
            return false;
        }
        if(size/2 - index >=0){
            for(int i = 0 ; i <=index ;i++,ptr=ptr.getNext()){   
                System.out.println("the required data at the index "+index+" is : "+ptr.getData());
            }
        }
        else{
            for(int i = 0 ; i <=size - index ;i++,ptr=ptr.getPrev()){   
                System.out.println("the required data at the index "+index+"  : "+ptr.getData());
            }
        }
        return true;
    }
}
class head{
    private node serializer ; 
    private int size ; 
    public head(node serializer){
        this.serializer = serializer;
        this.size = 0 ; 
    }
        /**
     * @return node return the serializer
     */
    public node getSerializer() {
        return serializer;
    }

    /**
     * @param serializer the serializer to set
     */
    public void setSerializer(node serializer) {
        this.serializer = serializer;
    }

    /**
     * @return int return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
}
public class db_link_list {
    public static void main(String[] args) {
        node node = new node(); //serializer for all the nodes
        node.add_before(76,node.getHead());
        node.add_after(98,node.getHead());
        node.getNext().add_before(760,node.getHead());
        node.getOperations().print();
        System.out.print("size of the linked list is :" );
        System.out.println(node.getHead().getSize());
        System.out.println(node.getOperations().erase(2));
        node.getOperations().print();

    }   
}