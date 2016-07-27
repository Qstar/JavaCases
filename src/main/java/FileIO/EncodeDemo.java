package FileIO;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "慕课ABC";
        byte[] bytes1 = s.getBytes();
        for (byte b : bytes1) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();
        byte[] bytes2 = s.getBytes("gbk");
        //gbk编码中文占用2个字节,英文占用1个字节
        for (byte b : bytes2) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        byte[] bytes3 = s.getBytes("utf-8");
        //utf-8编码中文占用3个字节,英文占用1个字节
        for (byte b : bytes3) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        byte[] bytes4 = s.getBytes("utf-16be");
        //utf-16be编码中文占用2个字节,英文占用2个字节
        for (byte b : bytes4) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println();

        String str1 = new String(bytes4);
        System.out.println(str1);
        String str2 = new String(bytes4, "utf-16be");
        System.out.println(str2);
    }
}
