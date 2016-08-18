package util.array;

import java.util.Arrays;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 参考：java.util.Arrays.fill(T[], T)。
 * 参考：java.util.Arrays.fill(T[], int, int, T)。
 */
public class FillElement {
    public static void main(String[] args) {
        //使用循环：
        // Fill each element of array 'a' with 123
        byte[] a = new byte[10];
        for (int i = 0; i < a.length; i++)
            a[i] = 123;

        //（优先）使用标准库的方法：
        Arrays.fill(a, (byte) 123);
    }
}
