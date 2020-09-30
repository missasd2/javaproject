package JavaSE.mianshi;

/**
 * 枚举类
 * 枚举表示的类型其取值是必须有限的
 */
public class DayDemo {
    public static void main(String[] args) {
        Day friday = Day.FRIDAY;
        System.out.println(friday);
    }

    enum Day{
        MONDAY, TUESDAY, WEDNEDDAY,
        THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }


}
