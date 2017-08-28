package followUpInCodeInterview;

/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ≥ s.
 * If there isn't one, return -1 instead.
 * 
 * Example
 * Given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */

public class MinimumSizeSubarraySum {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        int j = 0, i = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                ans = Math.min(ans, j - i);
            }
            sum -= nums[i];
        }
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        return ans;
    }
}
