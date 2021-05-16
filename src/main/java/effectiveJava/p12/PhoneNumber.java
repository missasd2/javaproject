package effectiveJava.p12;

import DesignPattern.Builder.Factory.SimpleFactory.Phone;

public class PhoneNumber {
    private  int areaCode;
    private int prefix;
    private int lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    // 指定toString返回值的格式
    /*
    *  好处在于：可读性高
    *  坏处在于：格式的指定是永久的，对后续有影响
    * */
    @Override
    public String toString() {
        return String.format("%3d-%4d-%4d", areaCode, prefix, lineNum);
    }

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber(183, 9201, 1185);
        System.out.println(phoneNumber);
    }
}
