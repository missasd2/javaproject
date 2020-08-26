package jnp4.chp2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class Demo01 {
    public void defOutStream1(){
        /**
         * （1）释放模式
         * Java6 和更早版本中,
         * 为了得到正确的变量作用域，必须在try块外声明流变量，必须在try块内完成初始化；
         * 在一个finally块中关闭流；
         * 在关闭流之前需检查流变量是否为null，避免NullPointerException；
         * 可以用于socket、通道、JDBC
         */
        OutputStream out = null;
        try {
            out = new FileOutputStream("/tmp/data.txt");
            // 处理输出流
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (out != null){
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void defOutStream2(){
        /**
         * Java7 引入了 带资源的try 构造。
         * 不需要再try块之外声明流变量，完全可以在一个try块中的一个参数表中声明
         * 不需要finally自居。Java会对try块参数表中声明的所有AutoCloseable对象自动调用
         * close()。
         * 只要对象实现了Closeable接口，都可以使用“带资源的try”构造；
         */
        try (OutputStream out = new FileOutputStream("/tmp/data.txt")){
            // 处理输出流
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 可显示的ASCII字符是33到126之间的字符
     * 作用：写入每个72字符块后，就向输入流写入一个回车和一个换行。
     * 然后计算下一个起始字符，重复这个循环；
     */
    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacter = 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;
        byte[] line = new byte[numberOfCharactersPerLine + 2];

        while (true){
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                line[i - start] = (byte)( (i - firstPrintableCharacter)
                        % numberOfPrintableCharacter + firstPrintableCharacter
                );
                line[72] = (byte) '\r'; // 回车
                line[73] = (byte) '\n'; // 换行
                out.write(line);
                start = ( (start + 1) - firstPrintableCharacter) % numberOfPrintableCharacter + firstPrintableCharacter;

            }
        }
    }
}
