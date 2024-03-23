import Algorithms.bit_manuplation.merge;
public class test {
    public static void main(String[] args) {
        int arr1 [] = {11,22,33,34,3222};
        int arr2 [] = {22,23,50,2003};
        int [] arr = merge.merge_two(arr1, arr2);
        for (int i : arr){
            System.out.println(i);
        }
    }
}
