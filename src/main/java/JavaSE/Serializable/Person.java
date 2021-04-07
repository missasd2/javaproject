package JavaSE.Serializable;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -808675591588426149L;
    public Long id;
    public String name;
    //private int age;
    public final String userName;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
        //this.age = age;
        this.userName = "bob";
    }

//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", userName='" + userName + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +

                ", userName='" + userName + '\'' +
                '}';
    }
}
