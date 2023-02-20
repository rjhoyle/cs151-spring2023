package warmup3;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Represents a data set consisting of a collection of doubles.
 */
public class DataSet {
    private ArrayList<Double> data;

    /**
     * Create an empty data set.
     */
    public DataSet() {
        data = new ArrayList<Double>();
    }

    /**
     * Add a new value to the data set.
     * 
     * @param value The value to add.
     */
    public void add(double value) {
        data.add(value);
    }

    /**
     * Return the number of values in the data set.
     * 
     * @return the number of values in the data set.
     */
    public int size() {
        return data.size();
    }

    /**
     * Return the maximum value in the data set.
     * 
     * @return the maximum value in the data set.
     */
    public double max() {
        double max = Double.NEGATIVE_INFINITY;

        for (double value : data) {
            if (value > max)
                max = value;
        }

        return max;
    }

    /**
     * Return the minimum value in the data set.
     * 
     * @return the minimum value in the data set.
     */
    public double min() {
        double min = 0;

        for (double value : data) {
            if (value < min)
                min = value;
        }

        return min;
    }

    /**
     * Compute the mean of the data set.
     * 
     * @return the mean.
     */
    public double mean() {
        double sum = 0;

        for (double value : data) {
            sum += value;
        }
        return sum / data.size();
    }

    /**
     * Compute the median of the data set.
     * 
     * @return the median.
     */
    public double median() {
        // Sort the data.
        data.sort(Comparator.naturalOrder());

        // If there are an odd number of elements, take the middle one.
        // If there are an even number, take the mean of the middle two.
        int size = data.size();
        int half = size / 2;

        if (size % 2 == 0) {
            return (data.get(half) + data.get(half + 1)) / 2;
        }
        return data.get(half);
    }
}
