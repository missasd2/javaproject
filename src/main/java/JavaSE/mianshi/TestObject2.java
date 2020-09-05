package JavaSE.mianshi;

public class TestObject2 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student();
        s1.setName("Tom");
        Student s2 = s1;
        System.out.println(s2 == s1); // true

        //
        Student s3 = (Student)s1.clone();
        System.out.println(s3 == s1); // false
    }
}
