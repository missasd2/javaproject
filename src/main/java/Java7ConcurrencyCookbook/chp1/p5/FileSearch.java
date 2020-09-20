package Java7ConcurrencyCookbook.chp1.p5;

import java.io.File;

public class FileSearch implements Runnable{

    private String initPath;
    private String fileName;

    public FileSearch(String initPath, String fileName){
        // 初始文件夹
        this.initPath = initPath;
        // 将要查找的文件夹
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()){
            try {
                directoryProcess(file, fileName);
            }catch (InterruptedException e){
                System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
            }
        }
    }

    private static void directoryProcess(File file, String fileName)  throws InterruptedException{
       File[] list = file.listFiles();
       if (list != null){
           for (int i = 0; i < list.length; i++) {
               if (list[i].isDirectory()){
                   directoryProcess(list[i],fileName);
               }else {
                   fileProcess(list[i],fileName);
               }
           }
       }
       if (Thread.interrupted()){
           throw new InterruptedException();
       }
    }

    private static void fileProcess(File file, String fileName) throws InterruptedException{
        if (file.getName().equals(fileName)){
            System.out.printf("%s : %s \n",Thread.currentThread().getName(), file.getAbsolutePath());
        }

        if (Thread.interrupted()){
            throw new InterruptedException();
        }

    }
}
