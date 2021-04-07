package DesignPattern.Behavior.chain.chain_1;

public class CeoHandler implements Handler{

    @Override
    public Boolean process(Request request) {
        return true;
    }
}
