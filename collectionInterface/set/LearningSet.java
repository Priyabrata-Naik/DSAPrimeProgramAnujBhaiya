package collectionInterface.set;

import java.util.*;

public class LearningSet {
    public static void main(String[] args) {

//        Set<Integer> set = new HashSet<>(); // O(1)
//        Set<Integer> set = new LinkedHashSet<>(); // O(n)
//        Set<Integer> set = new LinkedHashSet<>(); // O(logn)
//
//        set.add(40);
//        set.add(30);
//        set.add(60);
//        set.add(10);
//        set.add(40);
//
//        System.out.println(set);
////        Remove operation takes O(1) in HashSet and O(n) in LinkedHashSet
//        set.remove(10);
//        System.out.println(set.contains(30));
//        System.out.println(set);

//        Set<Student> studentSet = new HashSet<>();
//
//        studentSet.add(new Student(1,"Shark"));
//        studentSet.add(new Student(1,"Shark"));
//        studentSet.add(new Student(2,"Shark"));
//
//        System.out.println(studentSet);

//        System.out.println(Color.BLUE);

        EnumSet<Color> enumSet = EnumSet.allOf(Color.class);

        System.out.println(enumSet);

    }
    enum Color{
        RED,GREEN, BLUE
    }
}
class Student{
    int rollNo;
    String name;
    public Student(int rollNo, String name){
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo == student.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }
}
