package trees;
import stack_quee.quees.operations;
import stack_quee.quees.quee_dtype;

class node{
    private int data;
    private node leftNode;
    private node rightNode;
    public node(int value){
        this.data = value;
        this.leftNode = null;
        this.rightNode = null;
    }
    int repeat ; 
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
     * @return node return the leftNode
     */
    public node getLeftNode() {
        return leftNode;
    }

    /**
     * @param leftNode the leftNode to set
     */
    public void setLeftNode(node leftNode) {
        this.leftNode = leftNode;
    }

    /**
     * @return node return the rightNode
     */
    public node getRightNode() {
        return rightNode;
    }

    /**
     * @param rightNode the rightNode to set
     */
    public void setRightNode(node rightNode) {
        this.rightNode = rightNode;
    }
    public boolean search(int data){
        if (data == this.data){
            return true ;
        }
        else{
            if (data > this.data){
                return search(data,this.getRightNode());
            }
            else{
                return search(data , this.getLeftNode());
            }
        }
    }
    public boolean search(int data , node ptr){
        if (data > ptr.getData()){
            if(ptr.getRightNode() == null){
                return false;
            }
            return search(data,ptr.getRightNode());
        }
        else if(data < ptr.getData()){
            if(ptr.getLeftNode() == null){
                return false;
            }
            return search(data , ptr.getLeftNode()) ; 
        }
        else{
            return true;
        }

    }

}
class trees{
    node base;
    public trees(int value){
        base = new node(value);
    }

    public boolean insert(int value , node ptr){
        if (value > ptr.getData()){
            if(ptr.getRightNode() == null){
                node data = new node(value);
                ptr.setRightNode(data);
                return true;
            }
           return insert(value , ptr.getRightNode()) ;
        }
        else if(value < base.getData()){
            if(ptr.getLeftNode() ==null)
            {
                node data = new node(value);
                ptr.setLeftNode(data);
                return true;
            }
            return insert(value,ptr.getLeftNode());
        }
        else{
            base.repeat ++;
            return false;        // when duplicate value given we return false
        }
    }
    public boolean search(int data){
        if (data == base.getData()){
            return true ;
        }
        else{
            if (data > base.getData()){
                return search(data,base.getRightNode());
            }
            else{
                return search(data , base.getLeftNode());
            }
        }
    }

    public boolean search(int data , node ptr){
        if (data > ptr.getData()){
            if(ptr.getRightNode() == null){
                return false;
            }
            return search(data,ptr.getRightNode());
        }
        else if(data < ptr.getData()){
            if(ptr.getLeftNode() == null){
                return false;
            }
            return search(data , ptr.getLeftNode()) ; 
        }
        else{
            return true;
        }

    }
    public void dfs(node root){ // it uses the stack which is compilers stack to get data 
        if (root != null){
        dfs(root.getLeftNode());
        System.out.println(root.getData());
        dfs(root.getRightNode());
        }
    }
    public void print_data(node n){
        if(n.getLeftNode() != null){
            print_data(n.getLeftNode());
        }
        System.out.println(n.getData());

        if(n.getRightNode() != null){
            print_data(n.getRightNode());
        }
    }
}
public class tree{
    public static void main(String[] args) {
        trees t1 = new trees(10);
        t1.insert(90,t1.base);
        t1.insert(999,t1.base);  
        t1.insert(0,t1.base);
        t1.insert(-9,t1.base);  
        t1.insert(1,t1.base);
        t1.insert(3,t1.base);
        t1.insert(-19,t1.base);  
        t1.insert(221,t1.base);
        System.out.println(t1.search(999));
        System.out.println(t1.search(0));
        System.out.println(t1.search(992));
        System.out.println(t1.base.getLeftNode().search(0));
        t1.print_data(t1.base);
        System.out.println("dfs starts now");
        t1.dfs(t1.base);
    }

}