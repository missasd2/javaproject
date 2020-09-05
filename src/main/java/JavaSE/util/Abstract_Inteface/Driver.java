package JavaSE.util.Abstract_Inteface;

public class Driver extends People{
    private String work;

    public Driver(String work){
        this.work = work;
    }
    @Override
    public void work() {
        System.out.println("我的职业是： " + work);
    }

    public static void main(String[] args) {
        Driver driv = new Driver("司机");
        driv.work();
    }
}
