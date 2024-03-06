public class MyHashMap {
    int arr [] = new int[26]; 

    public MyHashMap(){
    }
    
    public void put(int key, int value) {
        arr[key] = value;
    }
    
    public int get(int key) {
        return arr[key];
    }
    
    public void remove(int key) {
        arr[key] = 0 ; 
    }

}