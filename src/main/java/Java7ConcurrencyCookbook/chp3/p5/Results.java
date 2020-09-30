package Java7ConcurrencyCookbook.chp3.p5;
// 保存矩阵中每行找到指定数字的次数

//public class Results {
//    private int[] data;
//
//    public Results(int size){
//        data = new int[size];
//    }
//    // 传入参数指定了数组的索引position, 及其对应的value
//    public void setData(int position, int value){
//       data[position] = value;
//    }
//
//    // 返回结果数组
//    public int[] getData(){
//        return data;
//    }
//}
public class Results {

    /**
     * Array to store the number of occurrences of the number in each row of the array
     */
    private int data[];

    /**
     * Constructor of the class. Initializes its attributes
     * @param size Size of the array to store the results
     */
    public Results(int size){
        data=new int[size];
    }

    /**
     * Sets the value of one position in the array of results
     * @param position Position in the array
     * @param value Value to set in that position
     */
    public void  setData(int position, int value){
        data[position]=value;
    }

    /**
     * Returns the array of results
     * @return the array of results
     */
    public int[] getData(){
        return data;
    }
}
