package algs4.chp2.p4;

/**
 * 基于堆的优先队列
 */
public class MaxPQ2<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N = 0;

    public MaxPQ2(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }
    public Key delMax(){
        Key max = pq[1]; // 从根节点得到最大元素
        exch(1, N--);
        pq[N+1] = null; // 防止越界
        sink(1); // 恢复堆的有界性
        return max;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    // 堆由下至上的有序化()上浮的实现
    private void swim(int n) {

    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;

    }
    private void sink(int k){

    }
}
