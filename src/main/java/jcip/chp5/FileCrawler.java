package jcip.chp5;

import jdk.nashorn.internal.ir.Block;
import org.aspectj.org.eclipse.jdt.internal.core.search.indexing.IndexManager;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 程序清单5-8 桌面搜索应用程序中的生产者-消费者任务
 * 阻塞队列的 put 和 offer方法的区别
 *  put方法：当队列满时，则put方法调用者将会被阻塞
 *  offer方法：当队列满时，offer方法会返回失败状态
 */
public class FileCrawler implements Runnable{
    private final BlockingQueue<File> fileQueue;
    private final FileFilter fileFilter;
    private final File root;
    private static final int BOUND = 1024; // 假设阻塞队列为有界队列
    private static final int N_CONSUMERS = 10; // 假设消费者线程有10个

    public FileCrawler(BlockingQueue<File> fileQueue, FileFilter fileFilter, File root) {
        this.fileQueue = fileQueue;
        this.fileFilter = fileFilter;
        this.root = root;
    }

    @Override
    public void run() {
        try {
            crawl(root);
        }catch (InterruptedException e) {
            // 中断
            Thread.currentThread().interrupt();
        }
    }

    private void crawl(File root) throws InterruptedException{
        File[] entries = root.listFiles(fileFilter);
        if (entries != null) {
            for (File entry: entries) {
                if (entry.isDirectory()) {
                    crawl(entry);
                }else if (!alreadyIndexed(entry)) {
                    fileQueue.put(entry);
                }
            }
        }
    }

    private boolean alreadyIndexed(File entry) {
        return fileQueue.contains(entry);
    }

    public class Indexer implements Runnable {
        private final BlockingQueue<File> queue;

        public Indexer(BlockingQueue<File> queue) {
            this.queue = queue;
        }

        private void indexFile(File file) {

        }

        @Override
        public void run() {
            try {
                while (true) {
                    // take方法，当队列为空时，会阻塞当前线程
                    indexFile(queue.take());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public  void startIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingQueue<File>(BOUND);
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        };
        for (File root : roots) {
            new Thread(new FileCrawler(queue, fileFilter, root)).start();
        }

        for (int i = 0; i < N_CONSUMERS; i++) {
            new Thread(new Indexer(queue)).start();
        }
    }
}
