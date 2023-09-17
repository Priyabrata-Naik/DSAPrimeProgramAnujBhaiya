package oops2.learningPackages;

import oops2.learnEncapsulation.MainInEncapsulation;

public class Teacher {

    public int teachingClass;
    private int id;
//    I make it public as it is not in same package
    public String degree; // default or package-private
    protected int studentCount;

    public static void main(String[] args) {
        Teacher obj = new Teacher();
        obj.teachingClass = 12;
        obj.id = 334;
        MainInEncapsulation.printHello();
    }
}
