package dynamicProblem1;

/**
 * There are n coins with different value in a line.
 * Two players take turns to take one or two coins from left side until there are no more coins left.
 * The player who take the coins with the most value wins.
 * Could you please decide the first player will win or lose?
 * 
 * Example
 * Given values array A = [1,2,2], return true.
 * Given A = [1,2,4], return false.
 */

public class CoinsInALine2 {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i -  1] + values[n - i];
        }

        int[] dp = new int[n + 1];
        dp[1] = values[n - 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(sum[i] - dp[i - 1], sum[i] - dp[i - 2]);
        }
            
        return dp[n]  > sum[n] / 2;
    }
}
