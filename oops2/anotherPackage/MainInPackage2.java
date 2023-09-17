package oops2.anotherPackage;

import oops2.learnEncapsulation.MainInEncapsulation;
import oops2.learningPackages.Teacher;

public class MainInPackage2 {

    public static void main(String[] args) {

        Teacher obj = new Teacher();
        obj.teachingClass = 12;
//		id is not accessible as it private in its class
//		obj.id = 3;
        obj.degree = "PHD";

    }
}
