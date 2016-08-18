package util.array;

import java.util.Arrays;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 参考：java.util.Arrays.copyOf(T[], int)。
 * 参考：java.util.Arrays.copyOfRange(T[], int, int)。
 */
public class AdjustArraySize {
    public static void main(String[] args) {
        //使用循环（扩大规模）：
        // Make array 'a' larger to newLen
        byte[] a = new byte[10];
        byte[] b = new byte[20];
        for (int i = 0; i < a.length; i++)  // Goes up to length of A
            b[i] = a[i];
        a = b;

        //使用循环（减小规模）：
        // Make array 'a' smaller to newLen
        byte[] a1 = new byte[10];
        byte[] b1 = new byte[5];
        for (int i = 0; i < b1.length; i++)  // Goes up to length of B
            b1[i] = a1[i];
        a1 = b1;

        //（优先）使用标准库的方法：
        int newLen = 10;
        a = Arrays.copyOf(a, newLen);
    }
}
