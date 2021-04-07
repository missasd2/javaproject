package ArtofConcurrent.chp5.p1;

public abstract class Game {

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    // 模板; final修饰地方法，子类不可以被重写，但是子类可以继承使用
    public final void play(){
        // 初始化游戏
        initialize();

        // 开始游戏
        startPlay();

        // 结束游戏
        endPlay();
    }
}
