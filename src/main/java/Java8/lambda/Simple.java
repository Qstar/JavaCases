package Java8.lambda;

import java.util.Arrays;
import java.util.List;

public class Simple {
    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players = Arrays.asList(atp);

        // 以前的循环方式
        System.out.println("old loop");
        for (String player : players) {
            System.out.print(player + "; ");
        }
        System.out.println();

        // 使用 lambda 表达式以及函数操作(functional operation)
        System.out.println("----------------------functional operation loop");
        players.forEach((player) -> System.out.print(player + "; "));
        System.out.println();

        // 在 Java 8 中使用双冒号操作符(double colon operator)
        System.out.println("----------------------double colon operator loop");
        players.forEach(System.out::println);
    }
}
