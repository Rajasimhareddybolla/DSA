package stack_quee;
public class quee_dtype{ // implementaition via linked_list
    private int data ;
    private quee_dtype nextQuee;
    private quee_dtype prevQuee;
    public quee_dtype(int value , quee_dtype next){
        data =value;
        nextQuee = next;
    }
    public quee_dtype(int value){
        this(value,null);
    }
    public quee_dtype(){
        this(-999);
    }
        /**
     * @return quee return the prevQuee
     */
    public quee_dtype getPrevQuee() {
        return prevQuee;
    }

    /**
     * @param prevQuee the prevQuee to set
     */
    public void setPrevQuee(quee_dtype prevQuee) {
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
    public quee_dtype getNextQuee() {
        return nextQuee;
    }

    /**
     * @param nextQuee the nextQuee to set
     */
    public void setNextQuee(quee_dtype nextQuee) {
        this.nextQuee = nextQuee;
    }
}
class operations{
    private quee_dtype headQuee;
    private quee_dtype tailQuee;
    private int size ;
    public operations(quee_dtype heaQuee, quee_dtype tailQuee){
        this.headQuee = heaQuee;
        this.tailQuee = tailQuee;
        this.size = 0 ;
        this.headQuee.setNextQuee(this.tailQuee);
        this.tailQuee.setNextQuee(this.headQuee);
        this.headQuee.setPrevQuee(this.tailQuee);
        this.tailQuee.setPrevQuee(this.headQuee);
    }
    public void enquee(int data){
        quee_dtype temp_quee = new quee_dtype(data);
        temp_quee.setNextQuee(this.tailQuee);
        temp_quee.setPrevQuee(this.tailQuee.getPrevQuee());
        this.tailQuee.getPrevQuee().setNextQuee(temp_quee);
        this.tailQuee.setPrevQuee(temp_quee);
        size ++;
    }
    public int dequee(){
        quee_dtype next =  this.headQuee.getNextQuee().getNextQuee();
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
