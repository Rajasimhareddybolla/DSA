class MyHashSet {
    class node{
        int data;
        node next;
        public node(int data){
            this.data = data;
        }
        public node(int data,node next){
            this.data = data;
            this.next = next ;
        }
    }
    node arr[] ;
    int size ;
    int threshold;
    public MyHashSet() {
        this.arr = new node[8];
        this.size = 0;
        this.threshold =(int) 0.75 * arr.length;
    }
    private void check_resize(){
        if (this.size >= threshold){
            node []new_arr = new node[arr.length*2];
            for (node k : arr){
                int hash = hashing(k.data);
                new_arr[hash] = new node(k.data);
            }
            this.arr = new_arr;
        }
    }
    private int hashing(int no ){
        return no % arr.length;
    }
    public void add(int key) {
        this.arr[hashing(key)] =  new node(key) ; 
    }
    
    public void remove(int key) {
        node n =arr[hashing(key)];
        
    }
    
    public boolean contains(int key) {
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */