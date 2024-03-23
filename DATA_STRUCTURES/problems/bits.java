public class bits{
    public static void main(String[] args) {
        // 9 in 32 bit system 00001001
        // negation of that   11110110
        // add 1                      
        // -9 represents                          11111000
        byte no = 2;
        
    }
    // it's the generalised first method which ever comes to mind to loop and get a no 
    public  static int bit_counter(String s){
        int counter = 0 ;  
        for (int i =0 ; i<s.length() ;i++){
            if (s.charAt(i)=='1')
                counter++;
        }
        return counter;
    }
    // inbuilt func which gave no of ones if we pass in bytes  if we pass integer which is ok but on negitive integers it won't work
    public static int bit_counter_2(byte no ){
        return Integer.bitCount(no);
    }
    //  in this for every iteration we and with one for every place untill whole turns into zero
    public static int bit_counter_3(byte pno){
        byte mask = -0b10000000;
        int counter = 0 ;
        for (int i =0 ; i < 8 ;i++){
            if ((mask & pno) != 0){
                counter ++;
            }
            mask = (byte)(mask>>> 1);
        }
        return counter;
    }
    // in this n no and with the no-1
    public static int bit_counter_4(byte no ){
        int counter = 0 ;
        while (no != 0){
            no &= (no - 1);
        }
        return counter++;
    }
        // this is the official method in which you want to create three mask based on the pow(2,n) n then use the following operations

    public static int bit_counter_5(byte no){
        byte mask_1 = -0b01010101;
        byte mask_2 = -0b00110011;
        byte mask_3 = -0b00001111;
        int shift= 1;
        no = (byte)((no & mask_1) +(no>>shift & mask_1));
        shift = 2;
        no = (byte)((no & mask_2) +(no>>shift & mask_2));
        shift = 4;
        no = (byte )((no & mask_3) + (no>>shift & mask_3));
        return no;
    }
}