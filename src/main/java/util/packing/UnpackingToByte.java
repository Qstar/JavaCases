package util.packing;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 总是使用无符号右移操作符（>>>）对位进行包装（packing），不要使用算术右移操作符（>>）。
 */
public class UnpackingToByte {
    //把int分解（Unpacking）成4个字节
    byte[] unpackBigEndian(int x) {
        return new byte[]{
                (byte) (x >>> 24),
                (byte) (x >>> 16),
                (byte) (x >>> 8),
                (byte) (x)
        };
    }

    byte[] unpackLittleEndian(int x) {
        return new byte[]{
                (byte) (x),
                (byte) (x >>> 8),
                (byte) (x >>> 16),
                (byte) (x >>> 24)
        };
    }
}
