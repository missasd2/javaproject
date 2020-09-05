package JavaSE.util.Abstract_Inteface;

/**
 * 在类实现接口后，该类就会将接口中的方法继承过来，
 * 此时该类需要重写该抽象方法，完成具体的逻辑。
 *
 *
 */
public class Usb_A implements Usb{

    public void a(){
        System.out.println("我实现了Usb接口");
    }

    public static void main(String[] args) {
        Usb_A usb_a = new Usb_A();
        usb_a.a();
    }
}
