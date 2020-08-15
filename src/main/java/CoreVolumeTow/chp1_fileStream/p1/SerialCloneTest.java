package CoreVolumeTow.chp1_fileStream.p1;

public class SerialCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee harry = new Employee("Harry Hacker", 35000, 1989, 10, 1);
        Employee harry2 = (Employee) harry.clone();

        harry.raiseSalary(10);

        System.out.println(harry);
        // 可以看到通过序列化实现了深拷贝
        System.out.println(harry2);
    }
}
