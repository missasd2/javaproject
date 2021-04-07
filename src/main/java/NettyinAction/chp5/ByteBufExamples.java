package NettyinAction.chp5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.nio.NioSocketChannel;


import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Random;

public class ByteBufExamples {
    private final static Random random = new Random();
    private final static ByteBuf BYTE_BUF_FROM_SOMEWHERE = Unpooled.buffer(1024);
    private final static Channel CHANNEL_FROM_SOMEWHERE = new NioSocketChannel();
    private static final ChannelHandlerContext CHANNEL_HANDLER_CONTEXT_FROM_SOMEWHERE = new DummyChannelHandlerContext();

    private static void handleArray(byte[] array, int offset, int len) {}
    /**
     * 代码清单5-1 支撑数组
     */
    public static void heapBuffer() {
        ByteBuf heapBuf = BYTE_BUF_FROM_SOMEWHERE;
        if (heapBuf.hasArray()) { // 1. 检查一个ByteBuf是否有一个支撑数组
            byte[] array = heapBuf.array(); // 2. 如果有，则获取该数组的引用
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex(); // 3. 计算下一个字节的偏移量
            int length = heapBuf.readableBytes(); // 4. 获得可读字节数
            // 使用数组、偏移量和长度作为参数调用你的方法
            handleArray(array, offset, length);
        }
    }

    /**
     * 代码清单5-2 访问直接缓冲区的数据
     */
    public static void directBuffer() {
        ByteBuf directBuf = BYTE_BUF_FROM_SOMEWHERE;
        // 检查ByteBuf是否有数组支撑；如果不是，则这是一个直接缓冲区
        if (!directBuf.hasArray()) {
            // 2. 获取刻度字节数
            int length = directBuf.readableBytes();
            // 3. 分配一个新的数组来保存具有该长度的字节数据
            byte[] array = new byte[length];
            // 将字节复制到该数组
            directBuf.getBytes(directBuf.readerIndex(), array);
            // 使用数组，偏移量和长度作为参数调用你的方法
            handleArray(array, 0, length);
        }
    }

    /**
     * 代码清单5-3 使用ByteBuffer 的复合缓冲区模式
     */
    public static void byteBufferComposite(ByteBuffer header, ByteBuffer body) {
        // 1. 创建一个包含两个ByteBuffer的数组，用来保存这些消息组件。
        ByteBuffer[] message = new ByteBuffer[] {header,body};
        // 2. 创建新的ByteBuffer，用来保存所有这些数据的副本
        ByteBuffer message2 = ByteBuffer.allocate(header.remaining() + body.remaining());
        message2.put(header);
        message2.put(body);
        message2.flip();
    }
    /**
     * 代码清单5-4 使用CompositeByteBuf的复合缓冲区模式
     */
    public static void byteBufComposite() {
        CompositeByteBuf messageBuf = Unpooled.compositeBuffer();
        ByteBuf headerBuf = BYTE_BUF_FROM_SOMEWHERE;
        ByteBuf bodyBuf = BYTE_BUF_FROM_SOMEWHERE;
        // 1. 将ByteBuf 实例追加到CompositeByteBuf
        messageBuf.addComponents(headerBuf, bodyBuf);

        // n. 删除位于索引位置为0（第一个组件）的ByteBuf
        messageBuf.removeComponent(0);
        // n+1. 循环遍历所有ByteBuf实例
        for (ByteBuf buf : messageBuf) {
            System.out.println(buf.toString());
        }
    }
    /**
     * 代码清单5-5 访问CompositeByteBuf 中的数据
     */
    public static void byteBufCompositeArray() {
        CompositeByteBuf compBuf = Unpooled.compositeBuffer();
        // 1. 获得可读字节
        int length = compBuf.readableBytes();
        // 2. 分配一个具有可读字节数长度的新数组
        byte[] array = new byte[length];
        // 3. 将字节读到该数组中
        compBuf.getBytes(compBuf.readerIndex(), array);
        // 4. 使用偏移量和长度 作为参数使用该数组
        handleArray(array, 0, array.length);
    }
    /**
     * 代码清单5-6 访问ByteBuf中的数据
     */
    public static void byteBufRelativeAccess() {
        ByteBuf buf = BYTE_BUF_FROM_SOMEWHERE;
        for (int i = 0; i < buf.capacity(); i++) {
            byte b = buf.getByte(i);
            System.out.println((char) b);
        }
    }
    /**
     * 代码清单 5-7 读取所有数据
     */
    public static void readAllData() {
        ByteBuf buf = BYTE_BUF_FROM_SOMEWHERE;
        while (buf.isReadable()) {
            System.out.println(buf.readByte());
        }
    }
    /**
     * 代码清单 5-8 写数据
     */
    public static void write() {
        ByteBuf buf = BYTE_BUF_FROM_SOMEWHERE;
        // int 类型数据Java中占4个字节
        while (buf.writableBytes() >= 4) {
            buf.writeInt(random.nextInt());
        }
    }

    // 派生缓冲区
    /**
     * 代码清单5-10 对 ByteBuf进行切片 （非独立）
     */
    public static void byteBufSlice() {
        Charset utf8 = Charset.forName("UTF-8");
        // 1. 创建 ByteBuf 以保存所提供的字符串的字节
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks", utf8);
        // 2. 创建该 ByteBuf 从索引0 开始到索引 15 结束的分段的副本
        ByteBuf sliced = buf.copy(0, 15);
        // 3. 打印“Netty in Action”
        System.out.println(sliced.toString(utf8));
        // 4. 更新索引 0 处的字节
        buf.setByte(0, (byte)'J');
        // 5. 将会成功，因为数据不是共享
        assert buf.getByte(0) != sliced.getByte(0);
    }
    /**
     * 代码清单5-11 复制一个ByteBuf （独立的）
     */
    public static void byteBufCopy() {
        Charset utf8 = Charset.forName("UTF-8");
        //1. 创建 ByteBuf 以保存所提供的字符串的字节
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        //2. 创建 ByteBuf 从索引0开始到索引 15结束的分段的副本
        ByteBuf copy = buf.copy(0, 15);
        //3. 将打印"Netty in Action"
        System.out.println(copy.toString(utf8));
        //4. 更新索引 0 处的字节
        buf.setByte(0, (byte)'J');
        //5. 断言将会成功，因为数据不是共享的
        assert buf.getByte(0) != copy.getByte(0);

    }
    /**
     * 代码清单5-12 get（）和set（）方法；不会改变readerIndex 和  writerIndex
     */
    public static void byteBufSetGet(){
        Charset utf8 = Charset.forName("UTF-8");
        // 1. 创建一个新的 ByteBuf 以保存给定字符串的字节
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        // 2. 打印第一个字符 'N'
        System.out.println((char)buf.getByte(0));
        // 3. 存储当前的 readerIndex 和 writerIndex
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();
        // 4. 将索引 0 处的字节更新为字符'B'
        buf.setByte(0, (byte)'B');
        // 5. 打印第一个字符，现在是 'B'
        System.out.println((char) buf.getByte(0));
        // 6. 断言将会成功，因为这些操作不会修改读写索引
        assert readerIndex == buf.readerIndex();
        assert writerIndex == buf.writerIndex();
    }
    /**
     * 代码清单5-13 ByteBuf 上的read（）和write（）操作
     */
    public static void byteBufWriteRead() {
        Charset utf8 = Charset.forName("UTF-8");
        // 1. 创建一个新的 ByteBuf 以保存给定字符串的字节
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        // 2. 打印第一个字符 'N'
        System.out.println((char)buf.readByte()); // 返回当前readerIndex处的字节，并会将readerIndex的值加一
        // 3. 存储当前的readerIndex
        int readerIndex = buf.readerIndex();
        // 4. 存储当前的writerIndex
        int writerIndex = buf.writerIndex();
        // 5. 将字符 '?' 追加到缓冲区
        buf.writeByte((byte)'?');
        assert readerIndex == buf.readerIndex();
        // 6. 断言将会成功，因为 writeBuf() 方法移动了 writerIndex
        assert writerIndex != buf.writerIndex();
    }
    /**
     * 代码清单5-14 获取一个到ByteBufAllocator的引用
     */
    public static void obtainingByteBufAllocatorReference() {
        Channel channel = CHANNEL_FROM_SOMEWHERE;

        // 1. 从channel获取一个到ByteBufAllocator的引用
        ByteBufAllocator allocator = channel.alloc();

        // 2. 也可从ChannelHandler的 ChannelHandlerContext 获取一个到ByteBufAllocator的引用
        ChannelHandlerContext ctx = CHANNEL_HANDLER_CONTEXT_FROM_SOMEWHERE;
        ByteBufAllocator allocator1 = ctx.alloc();
    }
    /**
     * 代码清单 5-15 引用计数
      */
    public static void referenceCounting() {
        Channel channel = CHANNEL_FROM_SOMEWHERE;
        // 1. 从Channel 获取ByteBufAllocator
        ByteBufAllocator allocator = channel.alloc();

        // 从 ByteBufAllocator 分配一个ByteBuf
        ByteBuf buf = allocator.directBuffer();
        // 检查引用计数是否为预期的 1
        assert buf.refCnt() == 1;
    }

    /**
     * 代码清单 5-16 释放引用计数的对象
     */
    public static void releaseReferenceCountedObject() {
        ByteBuf buf = BYTE_BUF_FROM_SOMEWHERE;
        // 减少到该对象的活动引用。当减少到0是，该对象被释放，并且该方法返回 true
        boolean released = buf.release();
    }





}
