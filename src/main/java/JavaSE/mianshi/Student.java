package JavaSE.mianshi;

/**
 * Student 类：
 * 1 实现了Cloneable接口
 * 2 重写了clone()方法，并将可见性提升为public
 */
public class Student implements Cloneable{
    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 若使用protected限制父类的方法，
     * 则该方法仅父类和子类内部（即定义父类和子类的代码中）可以调用
     *
     * 无法通过对象进行调用。
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        // 若修饰符为protected则clone()方法仅Object类和子类Student类内部可以调用
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 = new Student();
        s1.setName("Peter");
        Student s2 = s1;
        // java赋值是复制对象引用
        // 字符串变量s1 s2 指向的都是同一个对象
        System.out.println(s1 == s2); // true
        Student s3 = (Student)s2.clone();
        System.out.println(s3 == s2); // false
    }
}
