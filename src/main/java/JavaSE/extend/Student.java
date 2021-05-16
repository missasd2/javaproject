package JavaSE.extend;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Student extends Person{
//    public Student() {
//
//    }

    public Student(String name) {
        super(name);
        System.out.println("this is student");
    }

    public static void main(String[] args) {
        Person s = new Student("s");

    }


}
//