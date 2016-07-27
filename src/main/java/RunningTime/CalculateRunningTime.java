package RunningTime;


public class CalculateRunningTime {
    public static void main(String[] args) {
        //currentTimeMillis()：返回当前时间自新纪元时间以来的毫秒值，long类型。
        long startTime = System.currentTimeMillis();
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Running Time(currentTimeMillis): " + estimatedTime);

        //nanoTime()：返回系统计时器当前的精确时间，纳秒值，这也是long类型。nanoTime()主要是用于计算相对时间而非绝对时间。
        long startTime1 = System.nanoTime();
        long estimatedTime1 = System.nanoTime() - startTime1;
        System.out.println("Running Time(nanoTime): " + estimatedTime1);
    }
}
