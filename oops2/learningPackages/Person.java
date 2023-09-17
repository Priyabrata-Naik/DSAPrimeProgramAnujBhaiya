package oops2.learningPackages;

public class Person {

    //	static value created only once & it refers to its class
    public static int count = 0;
    public static final String scientificName = "Homo Sapiens";

    public Person() {
        count++;
    }

    private int age;
    private String name;
    boolean canBeChange = true;

    public void setAge(int age) {
        if (canBeChange) {
            this.age = age;
        }
    }

    boolean canBeAccessed = false;

    public int getAge() {
        if (canBeAccessed)
            return age;
        return -1;
    }

}
