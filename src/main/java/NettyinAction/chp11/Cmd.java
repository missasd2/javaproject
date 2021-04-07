package NettyinAction.chp11;

import io.netty.buffer.ByteBuf;

/**
 * 代码清单11-9 Cmd POJO
 * 将帧（命令）的内容存储在 ByteBuf 中，一个ByteBuf用于名称，另一个用于参数
 */
public class Cmd {
    private final ByteBuf name;
    private final ByteBuf args;

    public Cmd(ByteBuf name, ByteBuf args) {
        this.name = name;
        this.args = args;
    }

    public ByteBuf name() {
        return name;
    }

    public ByteBuf args() {
        return args;
    }
}
