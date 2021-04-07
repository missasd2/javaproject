package JavaSE.copy;

public class School implements Cloneable{
    private String schoolName;
    private int stuNums;
    private Student stu;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getStuNums() {
        return stuNums;
    }

    public void setStuNums(int stuNums) {
        this.stuNums = stuNums;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    @Override
    protected School clone() throws CloneNotSupportedException {
        return (School) super.clone();
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", stuNums=" + stuNums +
                ", stu=" + stu +
                '}';
    }
}
