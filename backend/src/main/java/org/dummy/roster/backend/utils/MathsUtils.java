package org.dummy.roster.backend.utils;

/**
 * Maths.
 */
public final class MathsUtils {

    public static final String PLUS_MINUS_SIGN = "\u00B1";
    public static final int SAMPLE_SIZE = 100_000;

    /**
     * Constructor.
     */
    private MathsUtils() {
        //
    }

    /**
     * Calculate average.
     * @param a array of long
     * @return sum
     */
    public static double avg(long[] a) {
        if (a.length > 0) {
            double sum = 0;
            for (long e : a) {
                sum = sum + e;
            }
            return sum / a.length;
        }
        return 0;
    }

    /**
     * Calculate standard deviation.
     * @param a array of long
     * @param avg average
     * @return SD
     */
    public static double sd(long[] a, double avg) {
        if (a.length > 0) {
            double sum = 0;
            for (long e : a) {
                sum = sum + Math.pow((e - avg), 2);
            }
            return Math.sqrt(sum / a.length);
        }
        return 0;
    }
}
