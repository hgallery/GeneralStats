import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.DoubleStream;

class ListSummary {

    final boolean TYPE_POPULATION = true;
    final boolean TYPE_SAMPLE = false;
    private final List<Double> doubleList;

    ListSummary(List<Double> doubleList) {
        this.doubleList = doubleList;
    }

    List<Double> getDoubleList() {
        return doubleList;
    }

    Function<List<Double>, OptionalDouble> arithmeticMean = list -> {
        if (list.isEmpty() || list.contains(null))
            return OptionalDouble.empty();
        return list.stream().mapToDouble(Double::doubleValue).average();
    };

    Function<List<Double>, OptionalDouble> geometricMean = list -> {
        if (list.isEmpty() || list.contains(null))
            return OptionalDouble.empty();
        double multiplier = list.stream().reduce(1d, (i, r) -> i * (1d + r / 100d), (a, b) -> a * b);
        return OptionalDouble.of((Math.pow(multiplier, 1d / list.size()) - 1d) * 100d);
    };

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

    Function<List<Double>, OptionalDouble> maximum = list -> {
        if (list.isEmpty() || list.contains(null))
            return OptionalDouble.empty();
        return list.stream().mapToDouble(Double::doubleValue).max();
    };

    Function<List<Double>, OptionalDouble> minimum = list -> {
        if (list.isEmpty() || list.contains(null))
            return OptionalDouble.empty();
        return list.stream().mapToDouble(Double::doubleValue).min();
    };

    Function<List<Double>, OptionalDouble> sum = list -> {
        if (list.isEmpty() || list.contains(null))
            return OptionalDouble.empty();
        return OptionalDouble.of(list.stream().mapToDouble(Double::doubleValue).sum());
    };

    OptionalDouble findArithmeticMean() {
        return arithmeticMean.apply(doubleList);
    }

    OptionalDouble findGeometricMeanPercentage() {
        return geometricMean.apply(doubleList);
    }

    OptionalDouble findMedian() {
        return median.apply(doubleList);
    }

    OptionalDouble findMaximum() {
        return maximum.apply(doubleList);
    }

    OptionalDouble findMinimum() {
        return minimum.apply(doubleList);
    }

    OptionalDouble findSum() {
        return sum.apply(doubleList);
    }


    OptionalDouble findVariance(boolean type) {
        if (doubleList.isEmpty() || doubleList.contains(null))
            return OptionalDouble.empty();

        long varianceDenominator = type == TYPE_POPULATION ? doubleList.size() : doubleList.size() - 1;

        if (varianceDenominator <= 0)
            return OptionalDouble.empty();

        OptionalDouble optionalMean = arithmeticMean.apply(doubleList);

        if (optionalMean.isEmpty())
            return OptionalDouble.empty();

        double varianceNumerator = doubleList.stream()
                .mapToDouble(x -> x - optionalMean.getAsDouble())
                .map(x -> Math.pow(x, 2))
                .sum();

        return OptionalDouble.of(varianceNumerator / varianceDenominator);
    }


    OptionalDouble findStandardDeviation(boolean type) {

        OptionalDouble optionalVariance = findVariance(type);

        return optionalVariance.isPresent() ?
                OptionalDouble.of(Math.pow(optionalVariance.getAsDouble(), 0.5))
                : OptionalDouble.empty();
    }


}
