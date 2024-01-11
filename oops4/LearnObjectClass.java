package oops4;

import java.util.Objects;

public class LearnObjectClass {
    public static void main(String[] args) {
        Car obj1 = new Car("Buggati",2023);
        Car obj2 = new Car("Buggati",2023);
//        Car obj3 = obj1;
//        System.out.println(obj1);
//        System.out.println(obj1.equals(obj2));
//        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
//        System.out.println(obj3.hashCode());
        System.out.println(obj1.getClass());
        System.out.println(obj2.getClass());

    }

}
class Car{
    String model;
    int year;
    public Car(String model,int year){
        this.model = model;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, year);
    }

    //    public int hashCode(){
//        int initialNum = 31;
//        initialNum += year;
//        initialNum += model.hashCode();
//        return initialNum;
//    }
//    public boolean equals(Object obj){
//        Car that = (Car) obj;
//        if(this.model.equals(that.model) && this.year == that.year){
//            return true;
//        }
//        return false;
//    }
    @Override
    public String toString(){
        return "Car model = " + model + " and year = " + year;
    }
}
