import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.DoubleStream;

class ListStats {

    final List<Double> doubleList;
    ListStats(List<Double> doubleList) {this.doubleList = doubleList;}

    Function<List<Double>, OptionalDouble> median = list -> {
        if (list.isEmpty() || list.contains(null))
            return OptionalDouble.empty();

        DoubleStream sortedStream = list.stream()
                .mapToDouble(Double::doubleValue)  // returns a DoubleStream
                .sorted();

        return list.size() % 2 == 0 ?
                sortedStream.skip((list.size() / 2) - 1).limit(2).average() :
                sortedStream.skip(list.size() / 2).findFirst();
    };

    // Additional Functions can be added here...
    // Function<List<Double>, OptionalDouble> arithmeticMean
    // Function<List<Double>, OptionalDouble> max
    // Function<List<Double>, OptionalDouble> min
    // Function<List<Double>, OptionalDouble> geometricMean
    // and so on...

    OptionalDouble findMedian() { return median.apply(doubleList); }
}
