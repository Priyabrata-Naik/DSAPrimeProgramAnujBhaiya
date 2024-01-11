package oops4;

public class LearnPolymorphism {
    public static void main(String[] args) {

        Data d;
        d = new ChildData();
        d.printData();
        d.printData(5);
//        Can't find this method as 'd' linked to parent class
//        d.insideChild();

    }
}
class ChildData extends Data{
    @Override
    public void printData(){
        System.out.println("Overridden " + data);
    }
    public void insideChild(){

    }
}
