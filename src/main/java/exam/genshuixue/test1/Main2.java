package exam.genshuixue.test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 单链表交点
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 单链表找交点。判断两个链表是否相交，如果相交返回第一个相交的node，否则返回null。
 *
 *
 *
 * 输入描述
 * 	 a1 → a2
 *
 *            	     ↘
 *
 *                         c1 → c2 → c3
 *
 *            	     ↗
 *
 * b1 → b2 → b3
 *
 * 输出描述
 * 输出c1
 *
 *
 * 样例输入
 * 1,2,3,4,5,6
 * 7,8,9
 * 样例输出
 * null
 */
public class Main2 {
    public static class Node {

        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static Node getCommon(Node headA, Node headB) {
        if(headA == null || headB == null) return null;
        Node first = headA;
        int a = 0;
        Node second = headB;
        int b = 0;
        while(first != null){
            a++;
            first = first.next;
        }
        while(second != null){
            b++;
            second = second.next;
        }
        Node cu1 = headA;
        Node cu2 = headB;
        if(a - b <= 0){
            for(int i = 0; i < b - a; i++){
                cu2 = cu2.next;
            }
        }else{
            for(int i = 0; i < a - b; i++){
                cu1 = cu1.next;
            }
        }

        while(cu1 != null && cu2 != null){
            if(cu1.getData() == cu2.getData()){
                break;
            }
            cu2 = cu2.next;
            cu1 = cu1.next;
        }
        return cu1;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String line1 = in.nextLine();
        String line2 = in.nextLine();

        Node headA = null;
        Node headB = null;

        Map<String, Node> map = new HashMap<String, Node>();

        if (line1 != null && line1.length() > 0) {
            String[] array1 = line1.split(",");
            headA = new Node();
            headA.setData(Integer.parseInt(array1[0].split("\\(")[0]));
            map.put(array1[0], headA);
            Node pre = headA;
            for (int i = 1; i < array1.length; i++) {
                Node node = map.get(array1[i]);
                if (node == null) {
                    node = new Node();
                    node.setData(Integer.parseInt(array1[i].split("\\(")[0]));
                    map.put(array1[i], node);
                }
                pre.next = node;
                pre = node;
            }
        }
        if (line2 != null && line2.length() > 0) {
            String[] array2 = line2.split(",");
            headB = map.get(array2[0]);
            if (headB == null) {
                headB = new Node();
                headB.setData(Integer.parseInt(array2[0].split("\\(")[0]));
                map.put(array2[0], headB);
            }
            Node pre = headB;
            for (int i = 1; i < array2.length; i++) {
                Node node = map.get(array2[i]);
                if (node == null) {
                    node = new Node();
                    node.setData(Integer.parseInt(array2[i].split("\\(")[0]));
                    map.put(array2[i], node);
                }
                pre.next = node;
                pre = node;
            }
        }

        Node res = getCommon(headA, headB);
        System.out.println(res == null ? res : res.getData());
    }
}
