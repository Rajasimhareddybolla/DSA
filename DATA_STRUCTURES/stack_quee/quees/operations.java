package stack_quee.quees;

public class operations {
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
    public void enquee(char data){
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
