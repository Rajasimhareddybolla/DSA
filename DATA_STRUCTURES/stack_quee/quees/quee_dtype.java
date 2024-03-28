package stack_quee.quees;
public class quee_dtype{ // implementaition via linked_list
    private char data ;
    private quee_dtype nextQuee;
    private quee_dtype prevQuee;
    public quee_dtype(char value , quee_dtype next){
        data =value;
        nextQuee = next;
    }
    public quee_dtype(char value){
        this(value,null);
    }
    public quee_dtype(){
        this(' ');
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
    public void setData(char data) {
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
