package hashingAndHashMaps.session_1;

import java.util.Objects;

public class GeneratingHashCodeOfCustomClass {
    public static void main(String[] args) {

        Boy b1 = new Boy(23,"Shark");
        Boy b2 = b1;
        Boy b3 = new Boy(23,"Bapu");

        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        System.out.println(b3.hashCode());

    }
    static class Boy{
        int age;
        String name;
        public Boy(int age, String name){
            this.age = age;
            this.name = name;
        }
        @Override
        public int hashCode(){
            return Objects.hash(name,age);
        }
    }
}
