package DesignPattern.Structural.Adapter;

/**
 * 结构型：适配器模式
 * 结合两个不兼容的接口：MediaPlayer， AdvancedMediaPlayer
 */
public interface MediaPlayer {
    public void play(String audioType, String fileName);
}
