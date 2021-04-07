package NettyinAction.chp1;

public class Teacher implements CallBack{

    public Teacher(Student s) {
        s.doHomeWork(this);
    }

    @Override
    public void checkUpHomeWork() {
        System.out.println("老师检查作业");
    }
}
