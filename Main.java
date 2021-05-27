import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main (String... args) {

List<Double> doubleList = Arrays.asList(5d, 6d, 1d, 2d, 3d, 4d, 7d, 8d);

ListStats listStats = new ListStats(doubleList);
System.out.print("Median is: ");
listStats.findMedian()
        .ifPresentOrElse(System.out::println, () -> System.out.println("not available"));

    }

}
