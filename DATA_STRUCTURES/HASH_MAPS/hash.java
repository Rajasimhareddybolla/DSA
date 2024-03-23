
class node {
    private int value;
    private node nextNode;
    public boolean  onDeleteMe   ;
    public  node(int value , node nexNode){ // on constructors dont mention any return type even void can get into errors
        this.value = value ; this.nextNode = nexNode; this.onDeleteMe = false;
    }
    public  node(int value){
        this.value = value ;
         this.nextNode = null;this.onDeleteMe = false;
    }
        /**
     * @return int return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return node return the nextNode
     */
    public node getNextNode() {
        return nextNode;
    }

    /**
     * @param nextNode the nextNode to set
     */
    public void setNextNode(node nextNode) {
        this.nextNode = nextNode;
    }
}
class MyHashMap {
    node [] p_array ;
    float thresh_hold ;
    int capacity  ; 
    int size ;  // says m how many nodes are fulled in the array 
    int keys ; // gave total how many keys which can able to find alpha 
    public MyHashMap(){
        this.p_array = new node[8] ; 
        this.capacity = this.p_array.length ; 
        this.size = 0 ; 
        this.thresh_hold = 5;
        this.keys = 0 ; 
    }
    private int hash_function (int v ){ // hear v means value which can be passed by user we have to return an appropriate 
        return v % capacity ; 
    }
    public void insert (int k ){
        int hash = this.hash_function(k);
        node head = p_array[hash];
        if (head == null){
            this.p_array[hash] = new node(k); 
            this.size ++ ; 
        }
        else if (head.onDeleteMe)
            head.setValue(k);

        else{
            while (true){ // go to the last node of theat partitions
                if(head.getValue() == k)
                    break;
                if(head.getNextNode() == null){
                    head.setNextNode(new node(k));
                }
                head = head.getNextNode();
            }
        }
        this.keys ++ ;
        if (this.size  >= thresh_hold)
            this.reHash();
        
    }
    public void rehash_insert(int k , node [] arr){
        int hash = this.hash_function(k);
        node head = arr[hash];
        if (head == null)
            arr[hash] = new node(k); 
        else{
            while (head.getNextNode() != null) // go to the last node of theat partitions
                head = head.getNextNode();
            head.setNextNode(new node(k));
        }
    }
    public void reHash(){
        node [] arr = new node[this.capacity * 2];
        this.capacity *= 2 ; // due to change in the hash function we are using rehash method after changing the capacity 
        for (int i = 0 ; i < this.capacity ; i ++){
            node head = this.p_array[i] ; 
            if (head != null){
                if (head.getNextNode()!=null)
                    rehash_insert(head.getValue(), arr);
                else
                    while (head !=null) {
                        rehash_insert(head.getValue(), arr);
                        head = head.getNextNode();
                    }
            }
        }
        this.p_array = arr;
    }
    private node search_n(int k ){
        node head =p_array[hash_function(k)];
        while(head != null){
            if (head.getValue() == k && !(head.onDeleteMe))
                return head;
            head = head.getNextNode();
        }
        return null;
    }
    public boolean search(int k ){
        return search_n(k) !=null;
    }
    public boolean delete(int k){
        node heaNode = search_n(k);
        if (heaNode!=null)
        {
            heaNode.onDeleteMe = true;
            return true;
        }
        this.size -- ; 
        return false;
    }
    public void print(){
        System.out.println("capacity    "+this.capacity);
        System.out.println(" size   "+this.size);

        for (int i = 0 ; i < this.capacity ; i ++){
            node head = this.p_array[i] ; 
            if (head != null && !head.onDeleteMe)
                System.out.println(head.getValue());
            else
                while (head !=null && !head.onDeleteMe) {
                    System.out.println("    "+head.getValue());
                    head = head.getNextNode();
                }
            }
        }
    }
    

public class hash{
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
       map.insert(76);
        map.print();
        map.insert(87);
        map.insert(999);
        System.out.println("hello world");
        map.insert(2);
        map.insert(870);
        map.insert(28);
        map.insert(1);
        System.out.println(map.search(76));
        map.print();
        System.out.println(map.delete(87));
        map.print();
    }
}