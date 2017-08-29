package binarySearchAndSweepLine;

/**
 * Implement double sqrt(double x) and x >= 0.
 * Compute and return the square root of x.
 * 
 * Example
 * Given n = 2 return 1.41421356
 */

public class Sqrtx2 {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        double left = 0.0;
        double right = x;
        double eps = 1e-12;

        if (right < 1.0) {
            right = 1.0;
        }

        while (right - left > eps) { 
            double mid = (right + left) / 2;
            if (mid * mid < x) {
                left = mid;
            }
            else {
                right = mid;
            }
        }

        return left;
    }
}
