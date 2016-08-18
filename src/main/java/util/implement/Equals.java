package util.implement;

import java.util.Arrays;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 参数必须是Object类型，不能是外围类。
 * foo.equals(null) 必须返回false，不能抛NullPointerException。（注意，null instanceof 任意类 总是返回false，因此上面的代码可以运行。）
 * 基本类型域（比如，int）的比较使用 == ，基本类型数组域的比较使用Arrays.equals()。
 * 覆盖equals()时，记得要相应地覆盖 hashCode()，与 equals() 保持一致。
 * 参考： java.lang.Object.equals(Object)。
 */
public class Equals {
    class Person {
        String name;
        int birthYear;
        byte[] raw;

        public boolean equals(Object obj) {
            if (!(obj instanceof Person))
                return false;

            Person other = (Person) obj;
            return name.equals(other.name)
                    && birthYear == other.birthYear
                    && Arrays.equals(raw, other.raw);
        }

        //TODO
        public int hashCode() {
            return 0;
        }
    }
}
