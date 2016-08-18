package util.array;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 参考：java.lang.System.arraycopy(Object, int, Object, int, int)。
 */
public class CopyElementRange {
    public static void main(String[] args) {
        //使用循环：
        // Copy 8 elements from array 'a' starting at offset 3
        // to array 'b' starting at offset 6,
        // assuming 'a' and 'b' are distinct arrays
        byte[] a = new byte[10];
        byte[] b = new byte[20];
        for (int i = 0; i < 8; i++)
            b[6 + i] = a[3 + i];

        //（优先）使用标准库的方法：
        System.arraycopy(a, 3, b, 6, 8);
    }
}
