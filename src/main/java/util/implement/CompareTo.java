package util.implement;

/**
 * Created by shuaiqiao on 2016/7/8.
 * <p>
 * 总是实现泛型版本 Comparable 而不是实现原始类型 Comparable 。因为这样可以节省代码量和减少不必要的麻烦。
 * 只关心返回结果的正负号（负/零/正），它们的大小不重要。
 * Comparator.compare()的实现与这个类似。
 * 参考：java.lang.Comparable。
 */
public class CompareTo {
    class Person implements Comparable<Person> {
        String firstName;
        String lastName;
        int birthday;

        // Compare by firstName, break ties by lastName, finally break ties by birthday
        public int compareTo(Person other) {
            if (firstName.compareTo(other.firstName) != 0)
                return firstName.compareTo(other.firstName);
            else if (lastName.compareTo(other.lastName) != 0)
                return lastName.compareTo(other.lastName);
            else if (birthday < other.birthday)
                return -1;
            else if (birthday > other.birthday)
                return 1;
            else
                return 0;
        }
    }
}
