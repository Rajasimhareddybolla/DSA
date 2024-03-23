package Algorithms.bit_manuplation;

public class merge {
    public static int[] merge_two(int []arr1 , int [] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int []new_arr  = new int [len1+len2];
        int index = 0;
        while(len1 != 0 && len2 != 0){
            if(arr1[arr1.length - len1] < arr2[arr2.length - len2]){
                new_arr[index] = arr1[arr1.length - len1];
                len1--;
            }
            else{
                new_arr[index] = arr2[arr2.length - len2];
                len2--;
            }
            index++;
        }
        while(len1 > 0 ){
            new_arr[index] = arr1[arr1.length - len1];
            len1--;
            index++;

        }
        while(len2 > 0){
            new_arr[index] = arr2[arr2.length - len2];
            len2--;
            index++;

        }
        return new_arr;
    }

}
