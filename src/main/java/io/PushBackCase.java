package io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class PushBackCase {
    public static void main(String[] args) {
        try {
            PushBackInputStreamDemo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回退流操作
     *
     * @throws IOException 文件不存在
     */
    public static void PushBackInputStreamDemo() throws IOException {
        String str = "hello,rollenholt";
        PushbackInputStream push;
        ByteArrayInputStream bat;
        bat = new ByteArrayInputStream(str.getBytes());
        push = new PushbackInputStream(bat);
        int temp;
        while ((temp = push.read()) != -1) {
            if (temp == ',') {
                push.unread(temp);
                temp = push.read();
                System.out.print("(回退" + (char) temp + ") ");
            } else {
                System.out.print((char) temp);
            }
        }
    }
}
