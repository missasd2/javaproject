package DesignPattern.Structual.ProxyPattern;

public class ProxyImageDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println(" ");
        // 图像不从磁盘加载
        image.display();
    }
}
