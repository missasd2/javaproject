package DesignPattern.Behavior.chain.chain_1;

import java.math.BigDecimal;

/**
 * 抽象出请求对象，它将在责任链上传递
 */
public class Request {
    private String name;
    private BigDecimal amount;

    public Request(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
