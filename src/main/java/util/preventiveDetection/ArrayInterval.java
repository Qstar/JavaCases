package util.preventiveDetection;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 不要认为所给的数组区间（比如，从off开始，读取len个元素）是不会越界。要显式地检测它。
 */
public class ArrayInterval {
    void frob(byte[] b, int off, int len) {
        if (b == null)
            throw new NullPointerException();
        if (off < 0 || off > b.length
                || len < 0 || b.length - off < len)
            throw new IndexOutOfBoundsException();
    }
}
