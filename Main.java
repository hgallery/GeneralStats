import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main (String... args) {

        List<Double> doubleList;

        doubleList = Arrays.asList(5d, 6d, 1d, 2d, 3d, 4d, 7d);
        //doubleList = Arrays.asList(5d, 6d, 1d, 2d, 3d, null, 7d);
        //doubleList = Collections.emptyList();
        //doubleList = Arrays.asList(5d);

        ListSummary listSummary = new ListSummary(doubleList);

        System.out.print("Arithmetic mean is: ");
        listSummary.findArithmeticMean()
                .ifPresentOrElse(System.out::println, () -> System.out.println("not available"));

        System.out.print("Geometric mean percentage is: ");
        listSummary.findGeometricMeanPercentage()
                .ifPresentOrElse(System.out::println, () -> System.out.println("not available"));

        System.out.print("Median is: ");
        listSummary.findMedian()
                .ifPresentOrElse(System.out::println, () -> System.out.println("not available"));

        System.out.print("Maximum is: ");
        listSummary.findMaximum()
                .ifPresentOrElse(System.out::println, () -> System.out.println("not available"));

        System.out.print("Minimum is: ");
        listSummary.findMinimum()
                .ifPresentOrElse(System.out::println, () -> System.out.println("not available"));

        System.out.print("Sum is: ");
        listSummary.findSum()
                .ifPresentOrElse(System.out::println, () -> System.out.println("not available"));

        System.out.print("Population Variance is: ");
        listSummary.findVariance(listSummary.TYPE_POPULATION)
                .ifPresentOrElse(System.out::println, () -> System.out.println("not available"));

        System.out.print("Population Standard Deviation is: ");
        listSummary.findStandardDeviation(listSummary.TYPE_POPULATION)
                .ifPresentOrElse(System.out::println, () -> System.out.println("not available"));

        System.out.print("Sample Variance is: ");
        listSummary.findVariance(listSummary.TYPE_SAMPLE)
                .ifPresentOrElse(System.out::println, () -> System.out.println("not available"));

        System.out.print("Sample Standard Deviation is: ");
        listSummary.findStandardDeviation(listSummary.TYPE_SAMPLE)
                .ifPresentOrElse(System.out::println, () -> System.out.println("not available"));

    }
}
