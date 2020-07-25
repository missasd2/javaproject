package algs4.chp1.p1;

/**
 * 2-3树 https://www.cnblogs.com/xiaohuiduan/p/11249598.html
 */
public class Tree23 {
    private class Data<Key extends Comparable<Key>, Value>{
        /**
         * 保存key和value的键值对
         */
        private Key key;
        private Value value;

        public Data(Key key, Value value){
            this.key = key;
            this.value = value;
        }
        public void displayData(){
            System.out.println("/" + key + "----" + value);
        }
    }

    /**
     * 保存树节点的类
     * @param <Key>
     * @param <Value>
     */
    private class Node23<Key extends Comparable<Key>, Value>{
        private static final int N = 3;
        // 该节点的父节点
        private Node23 parent;
        // 子节点，子节点有3个，分别是左子节点，中间子节点，右子节点
        private Node23[] chirldNodes = new Node23[N];
        // 代表节点保存的数据（为一个或者两个）
        private Data[] itemDatas = new Data[N-1];
        // 节点保存的数据个数
        private int itemNum = 0;



        public void displayNode(){
            for (int i = 0; i < itemNum; i++) {
                itemDatas[i].displayData();
            }
            System.out.println("/");
        }

        /**
         * 判断是否是叶子节点
         * @return
         */
        private boolean isLeaf(){
            // 假如不是叶子节点。必有左子树
            return chirldNodes[0] == null;
        }

    }
}
