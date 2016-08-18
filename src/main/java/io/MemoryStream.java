package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MemoryStream {
    public static void main(String[] args) {
        try {
            memUpperToLower();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用内存操作流将一个大写字母转化为小写字母
     *
     * @throws IOException
     */
    public static void memUpperToLower() throws IOException {
        String str = "ROLLENHOLT";
        ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int temp = 0;
        while ((temp = input.read()) != -1) {
            char ch = (char) temp;
            output.write(Character.toLowerCase(ch));
        }
        String outStr = output.toString();
        input.close();
        output.close();
        System.out.println(outStr);
    }
}
