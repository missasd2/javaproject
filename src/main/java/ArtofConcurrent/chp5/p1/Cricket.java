package ArtofConcurrent.chp5.p1;

public class Cricket extends Game {

    public void initialize(){
        System.out.println("初始化板球游戏");
    }

    public void startPlay(){
        System.out.println("开始玩板球");
    }

    public void endPlay(){
        System.out.println("结束游戏");
    }

    public static void main(String[] args) {
        Cricket cricket = new Cricket();
        cricket.play();
    }


}
