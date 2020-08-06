package HlighParallel.chp5.p7;

import com.google.common.util.concurrent.Futures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Search {
    // 待搜索的数组
    static int[] arr= {5, 52, 6, 3, 4, 10, 8, 100, 35, 78, 64, 31, 77, 90,
            45, 53, 89, 78, 1,2 };
    // 定义线程池
    static ExecutorService pool = Executors.newCachedThreadPool();
    // 定义线程数量
    static final  int Thread_num = 2;
    // 用于存放结果，存放的是元素在arr数组中的下标，默认-1表示未找到元素
    static AtomicInteger result = new AtomicInteger(-1);

    public static void createArray(){
        arr = new int[1000*1000*1000];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    /**
     *
     * @param searchValue
     * @param beginPos 搜索的起始位置
     * @param endPos 搜索的结束位置
     * @return
     */
    public static int search(int searchValue, int beginPos, int endPos){
        int i = 0;
        for (i = beginPos; i < endPos; i++) {
            //
            if (result.get()>=0){
                return result.get();
            }
            // 若条件(arr[i] == searchValue)成立，表示当前线程找到了需要的数据
            // 那么就将结果保存到result变量，
            // 这里使用CAS操作，若设置失败则表示其它线程已经先一步找到了结果
            if (arr[i] == searchValue){
                // 如果设置失败，表示其它线程已经先找到了
                if (!result.compareAndSet(-1, i)){
                    return result.get();
                }
                return i;
            }
        }
        return -1;
    }

    public static class SearchTask implements Callable<Integer>{
        int begin, end, searchValue;
        public SearchTask(int searchValue, int being, int end){
            this.begin = being;
            this.end = end;
            this.searchValue = searchValue;
        }
        public Integer call(){
            int re = search(searchValue, begin, end);
            return re;
        }
    }

    // 并行查找函数，根据线程数量对arr数组进行划分，并建立对应的任务提交给线程池处理
    public static int pSearch(int searchValue) throws ExecutionException, InterruptedException {
        int subArrSize = arr.length/Thread_num+1;
        List<Future<Integer>> re = new ArrayList<Future<Integer>>();
        //将原始数组arr划分为若干段，根据划分结果建立子任务
        // 每一个子任务都会返回一个Future对象，通过Future对象可以获得线程组得到的最终结果
        // 线程之间通过result共享彼此的信息，只要一个线程成功返回后，其他线程都会立即返回
        for (int i = 0; i < arr.length; i+=subArrSize) {
            int end = i+subArrSize;
            if (end >= arr.length) end=arr.length;
            re.add(pool.submit(new SearchTask(searchValue, i, end)));
        }
        for (Future<Integer> fu:re){
            if (fu.get()>=0) return fu.get();
        }
        return -1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int pos = pSearch(2);
        pool.shutdown();
        System.out.println(pos);
    }

}
