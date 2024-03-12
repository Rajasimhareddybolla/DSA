
interface system {
    public void print();
}
class laptop implements system{
    public void print(){
        System.out.println("i am working from a laptop");
    }   
}
class computer implements system{
    public void print(){
        System.out.println("i am working from a computer");
    }   
}
class employee{
    public employee(system s){
        s.print();
    }
}
public class compeny_x {
    public static void main(String [] args){
        laptop l_1 = new laptop();
        system c_1 = new computer(); // data type / indentifier is either interface or class both are accepteed
        employee e1 = new employee(c_1);
        employee e2 = new employee(l_1);
    }
}