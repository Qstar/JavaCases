package util.packing;

/**
 * Created by shuaiqiao on 2016/7/8.
 */
public class PackingToInt {
    //把4个字节包装（packing）成一个int
    int packBigEndian(byte[] b) {
        return (b[0] & 0xFF) << 24
                | (b[1] & 0xFF) << 16
                | (b[2] & 0xFF) << 8
                | (b[3] & 0xFF);
    }

    int packLittleEndian(byte[] b) {
        return (b[0] & 0xFF)
                | (b[1] & 0xFF) << 8
                | (b[2] & 0xFF) << 16
                | (b[3] & 0xFF) << 24;
    }
}
