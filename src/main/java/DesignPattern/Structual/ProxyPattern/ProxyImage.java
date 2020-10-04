package DesignPattern.Structual.ProxyPattern;

import groovy.util.IndentPrinter;

public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    /**
     * 调用display的时候，
     * 由于已经持有了RealImage对象，因此不用再从磁盘中加载
     */
    @Override
    public void display() {
        if (realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
