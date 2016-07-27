package radix;

import java.util.Arrays;

public class Radix {
    private static Byte[] int2Bytes(int id) {
        Byte[] arr = new Byte[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (byte) ((id >> i * 8) & 0xff);
        }
        return arr;
    }

    public static int byte2Int(byte[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += ((arr[i] & 0xff) << i * 8);
        }
        return result;
    }

    public static void main(String[] args) {
        Arrays.asList(int2Bytes(8143))
                .forEach(number -> System.out.print(number + ","));
    }
}
