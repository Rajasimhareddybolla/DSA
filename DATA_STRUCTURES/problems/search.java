import java.lang.Math;
class permutations_combinations{
    public int factorial(int k ){
        if (k == 1){
            return k;
        }
        return factorial(k-1)*k;
    }
    public double permutations(int n , int r ){
        return factorial(n) /( factorial(r)*factorial(n-r));
    }
    public double combinations(int n , int r){
        return factorial(n) / factorial(n-r);
    }
}

// in this one we have search a sequence of chars in the data given so i used a node insertion and deletion by using stack 
// and searching with O(m+n) where m = len(data) n = len(search_variable) which actually takes O(m*n) when you use normal for loop
// hear n = len(search_data) added becoz on hash_equal you need to crosscheck right so we will loop to check its really matches or not 
// and m is to loop all of the m


//for usage import problems.*
//        search n = new search("abcdhell", "hell");
// System.out.println(n.start_search()); which gave the starting index of the search_index

// Fifo quees are used for  logic check notes

class node {
    private char c ;
    private node next ;
    public node(char k , node n ){
        this.c = k ;
        this.next = n ;
    }
    public node (char k ){
        this(k , null);
    }
    
    /**
     * @return char return the c
     */
    public char getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(char c) {
        this.c = c;
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
    
}
public class search{
    String data ;
    String search ;
    node head;
    node tail;
    int hash_code_d ;
    int hash_code_s ;
    public search(String data , String search){
        this.search = search;
        this.data = data;
        initialize();
    }
    private void initialize(){
        head = new node('z');
        node ptr = head;
        for (int n  =0 ; n < search.length() ; n++){
            this.hash_code_s += this.search.charAt(n);
            node temp = new node(this.data.charAt(n));
            ptr.setNext(temp);
            ptr = ptr.getNext();
        }
        
        this.tail = new node('t' , ptr) ;
        this.hash_code_d = hash_start();
    }
    public int start_search(){

        for (int i = search.length() ; i < data.length() +1 ; i ++){
            if (this.hash_code_d == this.hash_code_s ){
                if (cross_check()){
                    return i - search.length() ;
                }
            }
            insert(data.charAt(i)); // this function done in O(c) = O(1) becoz it is a constant time function
        }
        return -1;
    }

    private int hash_start(){ // one time callable function 
        node ptr = head.getNext();
        int hash_code = 0;
        while (ptr != null){
            hash_code += ptr.getC() ;
            ptr = ptr.getNext();
        }
        return hash_code ; 
    }
    private void rehash(char add , char remove){ // this is o(1)
        this.hash_code_d += add;
        this.hash_code_d -= remove;
    }
    private void insert( char c){ // include r.skip and r.push(char k)
        tail.getNext().setNext(new node(c));
        tail.setNext(tail.getNext().getNext());
        char removed = head.getNext().getC();
        head.setNext(head.getNext().getNext());
        rehash(c,removed);
    }
    private boolean cross_check(){
        node ptr = head.getNext();
        int i =0 ;
        while(ptr != null){
            if (ptr.getC() != search.charAt(i))
                return false;
            i++;
            ptr = ptr.getNext();
        }
        return true;
    }
}
