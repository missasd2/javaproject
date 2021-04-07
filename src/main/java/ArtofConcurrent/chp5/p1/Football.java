package ArtofConcurrent.chp5.p1;

public class Football extends Game {

    public void initialize(){
        System.out.println("足球游戏初始化");
    }

    public void startPlay(){
        System.out.println("开始足球游戏");
    }

    public void endPlay(){
        System.out.println("结束足球游戏");
    }

    public static void main(String[] args) {
        Football football = new Football();
        football.play();
    }
}
