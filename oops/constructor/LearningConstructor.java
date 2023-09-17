package oops.constructor;

public class LearningConstructor {
    public static void main(String[] args) {

        Complex num1 = new Complex(3,4);
        Complex num2 = new Complex(5,2);

        num1.print();
        num2.print();

        Complex res = num1.add(num2);

        res.print();
    }
}
class Complex{
    int a,b ;
    public Complex(int real,int imaginary){
        a = real;
        b = imaginary;
    }
    Complex add(Complex num2){
//        Complex ans = new Complex(a+num2.a,b+num2.b);
//        return ans;
        return new Complex(a+ num2.a,b+ num2.b);
    }
    void print(){
        System.out.println(a + " + "+b+"i");
    }
}
