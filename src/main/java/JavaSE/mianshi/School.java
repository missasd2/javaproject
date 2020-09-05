package JavaSE.mianshi;

public class School implements Cloneable{

    private String name;
    private Integer year;
    private Student student;

    public School() {
    }

    public School(String name, Integer year, Student student) {
        this.name = name;
        this.year = year;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", student=" + student +
                '}';
    }

    @Override
    public School clone() throws CloneNotSupportedException {
        // 显示地clone其引用成员
        Object obj = super.clone();
        Student a = ((School) obj).getStudent();
        ((School)obj).setStudent((Student) a.clone());

        return (School)obj;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student();
        student.setName("jerr");
        student.setAge(31);
        School s1 = new School();
        s1.setName("tommy");
        s1.setYear(13);
        s1.setStudent(student);

        School s2 = s1;
        System.out.println(s1 == s2); // true
        School s3 = (School)s1.clone();
        /**
         * 由于School类的属性不仅有基本类型，也包含其它实体类对象引用
         * 那么这些实体类对象都需要实现cloneable接口，并覆盖clone()方法；
         * 且调用类的clone()需要显示地clone其引用成员
         *
         */
        System.out.println(s1 == s3); // false
        /**
         * School{name='tommy', year=13, student=JavaSE.mianshi.Student@76ed5528}
         * School{name='tommy', year=13, student=JavaSE.mianshi.Student@2c7b84de}
         */
        System.out.println(s1);
        System.out.println(s3);
    }
}
