package jcip.chp3;

/**
 * 程序清单3-6 使内部的可变状态逸出 (不要这么做)
 *
 * 非私有方法getStates发布了，本应为私有的状态数组。
 *
 */
public class UnsafeState {
    private String[] states = new String[] {
            "AK", "AK"
    };

    // 从私非私有方法中返回一个states的引用，可能使得数组states已经逸出了它所在的作用域
    //
    public String[] getStates() {
        return states;
    }
}
