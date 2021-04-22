package effectiveJava.p11;

public final class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int linenum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(linenum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object obj) {
        // 1. 使用 == 检查参数是否为该对象的引用
        if (obj == this) {
            return true;
        }
        // 2. 检查参数是否具有正确的类型
        // 注意实现了接口的类的比较
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }
        // 3. 参数转换为正确的类型
        PhoneNumber pn = (PhoneNumber) obj;
        // 4. 对于类中的每个“重要”属性，
        // 检查该参数属性与对象对应的属性是否相匹配
        return pn.lineNum == lineNum &&
                pn.prefix == prefix &&
                pn.areaCode == areaCode;

    }
}
