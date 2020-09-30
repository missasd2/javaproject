package Java7ConcurrencyCookbook.chp2.p8;

public class FileMock {
    private String content[]; // 表示存储的文件的内容
    private int index; // 要从这个文件读取的内容的行号

    public FileMock(int size, int length){
        // 使用随机字符，初始化实例属性
        content = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder builder = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int indice = (int)Math.random()*255;
                builder.append((char)indice);
            }
            content[i] = builder.toString();
        }
        index = 0;
    }

    public boolean hasMoreLines(){
        return index < content.length;
    }

    public String getLine(){
        if (this.hasMoreLines()){
            System.out.println("Mock: " + (content.length - index));
            return content[index++];
        }
        return null;
    }
}
