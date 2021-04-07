package JavaSE.Serializable;

import java.io.*;

public class DeSerialTest {

    public static void main(String[] args) {
        Person p;
        try {
            FileInputStream fis = new FileInputStream("Person.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            p = (Person)ois.readObject();
            ois.close();
            System.out.println(p.toString());
            System.out.println(p.userName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
