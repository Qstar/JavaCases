package Java8.lambda;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParallelStreams {
    public static void main(String[] args) {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        //顺序排序
        long t00 = System.nanoTime();
        long count0 = values
                .stream()
                .sorted()
                .count();
        System.out.println(count0);
        long t11 = System.nanoTime();
        long millis0 = TimeUnit.NANOSECONDS.toMillis(t11 - t00);
        System.out.println(String.format("sequential sort took: %d ms", millis0));

        //并行排序
        long t0 = System.nanoTime();
        long count = values
                .parallelStream()
                .sorted()
                .count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }
}
