package util.application;

import java.util.Random;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 总是使用Java API方法去生成一个整数范围内的随机数。
 * 不要试图去使用 Math.abs(rand.nextInt()) % n 这些不确定的用法，因为它的结果是有偏差的。此外，它的结果值有可能是负数，比如当rand.nextInt() == Integer.MIN_VALUE时就会如此。
 * 参考：java.util.Random.nextInt(int)。
 */
public class RandomNextInt {
    Random rand = new Random();

    // Between 1 and 6, inclusive
    int diceRoll() {
        return rand.nextInt(6) + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new RandomNextInt().diceRoll());
        }
    }
}

