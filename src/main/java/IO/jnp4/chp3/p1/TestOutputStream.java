package IO.jnp4.chp3.p1;

import java.io.IOException;
import java.io.OutputStream;

public class TestOutputStream {

    /**
     * 使用write(byte[] data) 或 write(byte[] data, int offset, int length)
     * 将整行打包在1字节数组中，一次发送一行；（字节数组）
     */
    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 72;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;
        // 要发送的行，+2对应回车和换行
        byte[] line = new byte[numberOfCharactersPerLine + 2];

        while (true){
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                line[i - start] = (byte)((i - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter);
                line[72] = (byte)'r'; // 回车
                line[73] = (byte)'\n'; // 换行
                out.write(line);
                start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacters + firstPrintableCharacter;
            }
        }
    }

    public static void main(String[] args) {

    }
}
