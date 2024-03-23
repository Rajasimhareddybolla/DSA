package hash_raja;

import java.io.IOError;


class data{
    int data;
    boolean on_delete_me = false;
    private int copy ;
    public data(int key){
        this.data = key;
        this.copy = 1;
    }
    public int get_copy(){
        return this.copy;
    }
    public void set_copy(int set){
        if(set<0){
            throw new IOError(null);
        }
        this.copy = set;
    }
}
class hash_p {
    data arr[];
    int size ;
    int capacity ;
    float threshold ;
    public hash_p(int capacity){
        this.capacity = capacity ;
        this.size = 0;
        this.arr = new data[capacity];
        this.threshold =(float) (0.75*this.capacity) ;
    }
    public int  hash_f(int value){
        return value%capacity;
    }
    public int hash_probe (int key , int probe){ // collision is rare in dobule hashing
        return (hash_f(key)+probe*hash_f(key)+probe)%  capacity;  
    }
    public void check_resize(){     // importent function which cheack whether we need to resize the arr are not 
        if(this.size >= this.threshold)
        {
            this.capacity *=2;
            data ne_arr[] = new data[this.capacity];
            for (data j : this.arr){
                if (j != null){
                    int i = 1;
                        int hash = hash_probe(j.data, i);
                        while (ne_arr[hash] != null ){
                            if(ne_arr[hash].on_delete_me){
                                ne_arr[hash] = j ; 
                                break;
                            }
                            i++;
                            hash = hash_probe(j.data, i);
                        }
                        ne_arr[hash] = new data(j.data);
                }
            }
            this.arr = ne_arr;   
        }
    }
    public void insert(int key){
        int i = 1;
        int hash = hash_probe(key, i);
        boolean is_repetative = false;
        while (this.arr[hash] != null ){
            if(this.arr[hash].data == key) {
                this.arr[hash].set_copy(this.arr[hash].get_copy()+1);
                is_repetative = true;
                break;
            }
            if(this.arr[hash].on_delete_me){
                size++;
                this.arr[hash].data = key; 
                this.arr[hash].on_delete_me  = false;

                break;
            }
            i++;
            hash = hash_probe(key, i);
        }
        if (!is_repetative){
            size++;
            this.arr[hash] = new data(key);
            check_resize();
        }
      

    }
    public int search(int key){
        int i  = 1;
        int hash = hash_probe(key, i);
        while(this.arr[hash] != null ){
            if (this.arr[hash].data == key && !this.arr[hash].on_delete_me)
                return this.arr[hash].get_copy();
            i++;
            hash = hash_probe(key , i);
        }
        return -1;
    }
    public boolean delete(int key){
        int i  = 1;
        int hash = hash_probe(key, i);
        while(this.arr[hash] != null){
            
            if (this.arr[hash].data == key && !this.arr[hash].on_delete_me){
                if (this.arr[hash].get_copy() >1){
                    this.arr[hash].set_copy(this.arr[hash].get_copy()-1);
                }
                else{
                    this.arr[hash].on_delete_me  = true;
                    size--;
                    check_resize();
                    return true;
                }
            }
            else{
                System.out.println("cant'delete ");
            }
            i++;
            hash = hash_probe(key , i);
        }
        return false ;
    }

}
public class hash_raja{
    public static void main(String[] args) {
        hash_p hash_map = new hash_p(8);
        hash_map.insert(10);
        hash_map.insert(98);
        hash_map.insert(10);

        hash_map.delete(10);
        hash_map.delete(10);
        hash_map.delete(10);
        System.out.println(hash_map.search(10));
        hash_map.insert(10);
        hash_map.insert(100); // hear due to so many 10s hash function only producing either 0 or 4 but both are filled so it going to be an infinite loop 
        hash_map.insert(9899);
        hash_map.insert(108222);
        hash_map.insert(66454545);
    }
}