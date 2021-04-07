package pearls.chp1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * 生成在n范围内，不重复的k个随机数
 */
public class RandomNumber {
    public static final int ARRAY_LENGTH = 3000000;
    private int size;
    private List<Integer> arrayList;

    // 诉编译器忽略指定的警告，不用在编译完成后出现警告信息
    @SuppressWarnings("unchecked")
    RandomNumber() {
        arrayList = new ArrayList<Integer>();
        for (int i = 1; i < ARRAY_LENGTH; i++) {
            arrayList.add(i);
        }
    }

    public RandomNumber(int size) {
        this();
        this.size = size;
    }

    public List<Integer> generateRandNum() {
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            int itemp = arrayList.get(i);
            int rtemp = Math.abs(r.nextInt(ARRAY_LENGTH-i) + i);
            arrayList.set(i, arrayList.get(rtemp));
            arrayList.set(rtemp, itemp);
        }
        arrayList = arrayList.subList(0, size);
        return arrayList;
    }

    public static void print(Collection<Integer> array) {
        System.out.println(array);
    }

    public void writeFile(String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            String buf = arrayList.toString();
            String tempbuf = buf.substring(1, buf.length() - 1);
            bw.write(tempbuf);
            bw.flush();
            bw.close();
            osw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int size = 50;
        RandomNumber rand = new RandomNumber(size);
        RandomNumber.print(rand.generateRandNum());
        rand.writeFile("random.txt");
    }
}
