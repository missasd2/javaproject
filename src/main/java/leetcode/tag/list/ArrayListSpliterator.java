package leetcode.tag.list;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Spliterator;
import java.util.function.Consumer;

public  final class ArrayListSpliterator<E> implements Spliterator<E> {

    // 用于存放ArrayList对象
    private final ArrayList<E> list;
    // 起始位置（包含）， advance/split操作时会修改
    private int index;
    // 结束位置（不包含） -1表示到最后一个元素
    private int fence;
    // 用于存放list的modCount
    private int expectedModCount;

    ArrayListSpliterator(ArrayList<E> list, int origin, int fence,
                         int expectedModCount) {
        this.list = list;
        this.index = origin;
        this.fence = fence;
        this.expectedModCount = expectedModCount;
    }

    // 获取结束位置 （存在意义：首次初始化时需对fence和expectedModCount进行赋值）
    private int getFence() {
        int hi;
        ArrayList<E> lst;
        // fence < 0时，（第一次初始化时，fence才会小于0）
        if ( (hi = fence) < 0) {
            // list 为null时, fence0
            if ( (lst = list) == null) {
                hi = fence = 0;
            }else {
                // 否则，fence = list的长度
                //expectedModCount = lst.modCount();
                expectedModCount = lst.size(); // 错误的
                hi = fence = lst.size();
            }
        }
        return hi;
    }

    // 分割list，返回一个新分割出的spliterator实例
    public ArrayListSpliterator<E> trySplit() {
        // hi 为当前的结束位置
        // lo 为起始位置
        // 计算中间的位置
        int hi = getFence(), lo = index;
        int mid = (lo + hi) >>> 1;
        // 当lo >= mid，表示不能再分割，返回null
        // 当lo < mid时，可分割，切割 （lo, mid） 出去，
        // 同时更新index=mid
        return (lo >= mid) ? null :
                new ArrayListSpliterator<E>(list, lo, index=mid, expectedModCount);
    }

    // 返回true时，表示可能还有元素未处理
    // 返回false时，没有剩余元素处理了
    public boolean tryAdvance(Consumer<? super E> action) {
        if (action == null) {
            throw  new NullPointerException();}
            // hi 为当前的结束位置
            // i 为起始位置
            int hi = getFence();
            int i = index;
            // 还有剩余元素未处理时
            if (i < hi) {
                // 处理i位置，index+1
//                @SuppressWarnings("unchecked")
//                        E e = (E)list.elementData[i];
                E e = (E) new Object();
                action.accept(e);
                // 遍历时，结构发生变更，抛错
//                if (list.modCount != expectedModCount)
//                    throw new ConcurrentModificationException();
                return true;
            }

        return false;
    }

    // 顺序遍历处理所有剩下的元素
    @Override
    public void forEachRemaining(Consumer<? super  E> action) {
        int i, hi, mc;
        ArrayList<E> lst;
        Object[] a;
        if (action == null) {
            throw  new NullPointerException();
        }
        //if ( (lst= list) != null && ( a = list.elementData) != null) {
        if ( (lst= list) != null ) {
            // 当fence<0时，表示fence和expectedModCount未初始化，可以思考一下这里是否能直接调用getFence()
            if ( (hi = fence) < 0) {
               /// mc = list.modCount();
                //mc = list.modCount();
                hi = lst.size();
            }
            else
                mc = expectedModCount;
//            if ( (i = index) >= 0 && (index = hi) <= a.length) {
            if ( (i = index) >= 0 ) {
                for (; i < hi; ++i) {
//                    @SuppressWarnings("unchecked")
//                            E e = (E) a[i];
                    E e = (E) new Object(); // 错误的
                    action.accept(e);
                }
                // 遍历时发生结构变更时抛出异常
//                if (lst.modCount() == mc)
//                    return;
            }
        }
        throw new ConcurrentModificationException();
    }

    public long estimateSize() {
        return (long) (getFence() - index);
    }

    public int characteristics() {
        // 打上特征值：可以返回size
        return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
    }
}
