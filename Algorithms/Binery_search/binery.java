class Binery_search {
        int array[] ;
        public Binery_search(int []arr){
            this.array = arr;
        }
        public boolean search(int data , int min , int max){
            if(min>max){
                return false;
            }
            int middle =( max+ min) / 2 ; 
            if(array[middle] < data){
                return search(data, middle +1, max) ;
            }
            else if (array[middle] > data){
                return search(data, min, middle -1);
            }
            else{
                return true;
            }
        }
    

}

public class binery{
    public static void main(String[] args) {
        int arr[] ={1,2,3,4,5,6,7};
        Binery_search search = new Binery_search(arr);
        System.out.println(search.search(4, 0, arr.length -1));
    }
}