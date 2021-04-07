package DesignPattern.Behavior.chain;

import org.aspectj.org.eclipse.jdt.internal.compiler.ast.UsesStatement;

public class ChainPatternDemo {

    // 手动设置责任链
    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information");

        // errorLogger.logMessage(AbstractLogger.DEBUG, "This is a debug level information.");
        //      调用errorLogger的nextLogger的 logMessage方法
        // fileLogger.logMessage(AbstractLogger.DEBUG, "This is a debug level information.");
        // 由于 this.level = 2; 导致  this.level <= level； 2 <= 2 因此会调用fileLogger的writeMessage方法
        // 由于nextLogger不为null，因此向下传播
        // 由于 this.level = 1; 导致 this.level <= level; 1 <= 2 因此会调用 consoleLogger的writeMessage方法

        loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug level information.");
//
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information");
    }
}
