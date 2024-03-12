public class test {

    public static void main(String[] args) {
        MyHashMap dict = new MyHashMap();
        dict.insert(23);
        dict.insert(98);
        dict.insert(9888);
        dict.insert(899);
        dict.insert(23);
        System.out.println("hello");
        dict.insert(98);
        dict.insert(9888);
        dict.insert(899);
        dict.insert(23);
        System.out.println(dict.delete(23));
        System.out.println(dict.search(23));
    }
}