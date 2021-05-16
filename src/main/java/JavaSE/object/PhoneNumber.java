package JavaSE.object;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {
    private int prefix;
    private int num;

    public PhoneNumber(int prefix, int num) {
        this.prefix = prefix;
        this.num = num;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }

        PhoneNumber tmp = (PhoneNumber)obj;

        return (tmp.prefix == prefix) && (tmp.num == num);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(prefix);
        result = 31 * result + Integer.hashCode(prefix);
        result = 31 * result + Integer.hashCode(num);
        return result;
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<>();
        map.put(new PhoneNumber(183, 12345678), "Jenny");
        System.out.println(map.get(new PhoneNumber(183, 12345678)));

    }
}
