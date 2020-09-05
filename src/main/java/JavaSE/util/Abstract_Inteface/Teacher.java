package JavaSE.util.Abstract_Inteface;

public class Teacher extends People{
    private String work;
    public Teacher(String work){
        this.work = work;
    }

    public Teacher(){}
    @Override
    public void work() {
        System.out.println("我的职业是: " + this.work);
    }

    public static void main(String[] args) {
        Teacher te = new Teacher("教师");
        te.work();
    }
}
