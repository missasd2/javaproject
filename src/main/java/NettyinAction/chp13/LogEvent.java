package NettyinAction.chp13;

import javax.xml.soap.SAAJResult;
import java.net.InetSocketAddress;

/**
 * 代码清单 13-1 LogEvent消息
 */
public final class LogEvent {
    public static final byte SEPARATOR = (byte)':';
    private final InetSocketAddress source;
    private final String logfile;
    private final String msg;
    private final long received;

    // 用于传出消息的构造函数
    public LogEvent(InetSocketAddress source, String logfile, String msg, long received) {
        this.source = source;
        this.logfile = logfile;
        this.msg = msg;
        this.received = received;
    }

    public LogEvent(InetSocketAddress source, long received, String logfile, String msg) {
        this.source = source;
        this.logfile = logfile;
        this.msg = msg;
        this.received = received;
    }

    // 返回发送LogEvent的源的 InetSocketAddress
    public InetSocketAddress getSource() {
        return source;
    }
    // 返回所发送的LogEvent 的日志文件的名称
    public String getLogfile() {
        return logfile;
    }

    public String getMsg() {
        return msg;
    }
    // 返回接收LogEvent的时间
    public long getReceivedTimestamp() {
        return received;
    }
}
