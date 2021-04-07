package JavaSE.Serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 序列化功能
 */
public class SerialTest {

    public static void main(String[] args) {
        Person p = new Person(1L, "hellokitty");
        //Person p = new Person(1L, "hellokitty");
        System.out.println("person Serial: " + p);
        try {
            FileOutputStream fos = new FileOutputStream("Person.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
