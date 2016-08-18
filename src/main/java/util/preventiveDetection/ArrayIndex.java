package util.preventiveDetection;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 不要认为所以给的数组索引不会越界。要显式地检测它。
 */
public class ArrayIndex {
    void frob(byte[] b, int index) {
        if (b == null)
            throw new NullPointerException();
        if (index < 0 || index >= b.length)
            throw new IndexOutOfBoundsException();
    }
}
