package DesignPattern.Behavior.chain.chain_1;

/**
 * 抽象出处理器
 */
public interface Handler {
    // 返回Boolean True = 成功
    // 返回Boolean False = 拒绝
    // 返回 null = 交下一个处理
    Boolean process(Request request);
}
