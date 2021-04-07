package DesignPattern.Behavior.chain.chain_1;

import java.math.BigDecimal;

/**
 * 不同的Handler实现类，代表了处理器
 */
public class ManagerHandler implements Handler{

    @Override
    public Boolean process(Request request) {
        if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
            return null;
        }
        //
        return !request.getName().equalsIgnoreCase("bob");
    }
}
