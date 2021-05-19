import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.DoubleStream;

public class ListSummary {

    private final List<Double> doubleList;

    ListSummary (List<Double> doubleList) {
        this.doubleList = doubleList;
    }

    List<Double> getDoubleList() {
        return doubleList;
    }

    OptionalDouble findArithmeticMean () {
        Function<List<Double>, OptionalDouble> arithmeticMean = list -> {
            if (list.isEmpty() || list.contains(null))
                return OptionalDouble.empty();
            return list.stream().mapToDouble(Double::doubleValue).average();
        };
        return arithmeticMean.apply(doubleList);
    }


    OptionalDouble findGeometricMeanPercentage() {
        // List<Double> is a list of percentage numbers
        Function<List<Double>, OptionalDouble> geometricMean = list -> {
            if (list.isEmpty() || list.contains(null))
                return OptionalDouble.empty();
            double multiplier = list.stream().reduce(1d, (a, b) -> (a * (1d + b / 100d)));
            return OptionalDouble.of((Math.pow(multiplier, 1d / list.size()) - 1d) * 100d);
        };
        return geometricMean.apply(doubleList);
    }


    OptionalDouble findMedian() {
        Function<List<Double>, OptionalDouble> median = list -> {

            if (list.isEmpty() || list.contains(null))
                return OptionalDouble.empty();

            DoubleStream sortedStream = list.stream()
                    .mapToDouble(Double::doubleValue)
                    .sorted();

            return list.size() % 2 == 0 ?
                    sortedStream.skip((list.size() / 2) - 1).limit(2).average() :
                    sortedStream.skip(list.size() / 2).findFirst();
        };
        return median.apply(doubleList);
    }


    OptionalDouble findMaximum() {
        Function<List<Double>, OptionalDouble> maximum = list -> {
            if (list.isEmpty() || list.contains(null))
                return OptionalDouble.empty();
            return list.stream().mapToDouble(Double::doubleValue).max();
        };
        return maximum.apply(doubleList);
    }


    OptionalDouble findMinimum() {
        Function<List<Double>, OptionalDouble> minimum = list -> {
            if (list.isEmpty() || list.contains(null))
                return OptionalDouble.empty();
            return list.stream().mapToDouble(Double::doubleValue).min();
        };
        return minimum.apply(doubleList);
    }

    OptionalDouble findSum() {
        Function<List<Double>, OptionalDouble> sum = list -> {
            if (list.isEmpty() || list.contains(null))
                return OptionalDouble.empty();
            return OptionalDouble.of(list.stream().mapToDouble(Double::doubleValue).sum());
        };
        return sum.apply(doubleList);
    }

}
