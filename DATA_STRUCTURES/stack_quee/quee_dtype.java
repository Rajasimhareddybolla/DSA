class quee{ // implementaition via linked_list
    private int data ;
    private quee nextQuee;
    private quee prevQuee;
    public quee(int value , quee next){
        data =value;
        nextQuee = next;
    }
    public quee(int value){
        this(value,null);
    }
    public quee(){
        this(-999);
    }
        /**
     * @return quee return the prevQuee
     */
    public quee getPrevQuee() {
        return prevQuee;
    }

    /**
     * @param prevQuee the prevQuee to set
     */
    public void setPrevQuee(quee prevQuee) {
        this.prevQuee = prevQuee;
    }
        /**
     * @return int return the data
     */
    public int getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return quee return the nextQuee
     */
    public quee getNextQuee() {
        return nextQuee;
    }

    /**
     * @param nextQuee the nextQuee to set
     */
    public void setNextQuee(quee nextQuee) {
        this.nextQuee = nextQuee;
    }
}
class operations{
    private quee headQuee;
    private quee tailQuee;
    private int size ;
    public operations(quee heaQuee, quee tailQuee){
        this.headQuee = heaQuee;
        this.tailQuee = tailQuee;
        this.size = 0 ;
        this.headQuee.setNextQuee(this.tailQuee);
        this.tailQuee.setNextQuee(this.headQuee);
        this.headQuee.setPrevQuee(this.tailQuee);
        this.tailQuee.setPrevQuee(this.headQuee);
    }
    public void enquee(int data){
        quee temp_quee = new quee(data);
        temp_quee.setNextQuee(this.tailQuee);
        temp_quee.setPrevQuee(this.tailQuee.getPrevQuee());
        this.tailQuee.getPrevQuee().setNextQuee(temp_quee);
        this.tailQuee.setPrevQuee(temp_quee);
        size ++;
    }
    public int dequee(){
        quee next =  this.headQuee.getNextQuee().getNextQuee();
        int value = next.getPrevQuee().getData();
        this.headQuee.setNextQuee(next);
        next.setPrevQuee(this.headQuee);
        size --;
        return value;
    }
    public boolean empty(){
        return !(this.size>0);
    }

}
public class  quee_dtype {
    public static void main(String[] args) {
        
        quee headQuee = new quee();
        quee tailQuee = new quee();
        operations op = new operations(headQuee, tailQuee);
        op.enquee(45);
        op.enquee(56);
        op.dequee();
        System.out.println(headQuee.getData() +"  "+headQuee.getNextQuee().getData()+"  "+headQuee.getNextQuee().getNextQuee().getData() );
    }
    
}