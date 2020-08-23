package leetcode.tag.String;

/**
 * Java StringBuffer 和 StringBuilder 类
 *
 *
 * StringBuffer是一字符串缓冲区对象，线程安全
 * 和数组相似是个容器（它的底层就是个可变长度的数组）。
 */
public class Buffer_ReaderString {

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("www");
        // append()方法，将指定的字符串追加到此字符序列
        buffer.append(".");
        buffer.append("baidu");
        buffer.append(".com");
        System.out.println(buffer); // www.baidu.com

        // public StringBuffer reverse() 将此字符序列用其反转形式取代。
        // reverse()方法会修改原对象;
        StringBuffer reverse = buffer.reverse();
        System.out.println(reverse); // moc.udiab.www
        System.out.println(buffer); // moc.udiab.www

        //  insert(int offset, String st)方法，在指定偏移处插入字符串
        // 可实现头插，尾插；
        StringBuffer buffer1 = new StringBuffer("T");
        buffer1.insert(0, "a");
        System.out.println(buffer1);
        buffer1.insert(buffer1.length(), ".bob");
        System.out.println(buffer1); // aT.bob

        // 查
        // int indexOf(String str)
        // 返回第一次出现的指定子字符串在该字符串中的索引。
        int b_index = buffer1.indexOf("b");
        System.out.println(b_index); // 3
        // int lastIndexOf(String str)
        //返回最右边出现的指定子字符串在此字符串中的索引。
        int b_lastIndexOf = buffer1.lastIndexOf("b");
        System.out.println(b_lastIndexOf); // 5

        // StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
    }
}
