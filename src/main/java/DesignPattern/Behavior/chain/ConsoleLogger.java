package DesignPattern.Behavior.chain;

public class ConsoleLogger extends AbstractLogger{

    @Override
    protected void write(String message) {
        System.out.println("Console Logger: " + message);
    }

    public ConsoleLogger(int level) {
        this.level = level;
    }
}
