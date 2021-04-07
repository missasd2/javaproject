package DesignPattern.Behavior.chain;

public class ErrorLogger extends AbstractLogger{

    @Override
    protected void write(String message) {
        System.out.println("Error logger: " + message);
    }

    public ErrorLogger(int level) {
        this.level = level;
    }
}
