package Java7ConcurrencyCookbook.chp3.p6;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable{
    // 用来存储查找的文件夹
    private String initPath;
    // 用来存储要查找的文件的扩展名
    private String  end;
    // 用来存储找到的文件的完整路径
    private List<String> results;
    // 控制任务不同阶段的同步
    private Phaser phaser;

    public FileSearch(String initPath, String end, List<String> results, Phaser phaser) {
        this.initPath = initPath;
        this.end = end;
        this.results = results;
        this.phaser = phaser;
    }

    public void directoryProcess(File file){
        File[] list = file.listFiles();
        if (list != null){
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()){
                    directoryProcess(list[i]);
                }else {
                    fileProcess(list[i]);
                }
            }
        }
    }
    // 判断传入的File对象的扩展名，若符合要求则加入结果集
    private void fileProcess(File file){
        if (file.getName().endsWith(end)){
            results.add(file.getAbsolutePath());
        }
    }

    private void fileResults(){
        List<String> newResults = new ArrayList<>();
        long actualDate = new Date().getTime();
        for (int i = 0; i < results.size(); i++) {
            File file = new File(results.get(i));
            long fileDate = file.lastModified();
            if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)){
                newResults.add(results.get(i));
            }

        }
        // 将获得的新列表引用赋给老列表
        results = newResults;
    }

    @Override
    public void run() {

    }
}
