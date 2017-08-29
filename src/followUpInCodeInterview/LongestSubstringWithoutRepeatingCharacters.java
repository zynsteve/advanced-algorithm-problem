package followUpInCodeInterview;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class LongestSubstringWithoutRepeatingCharacters {
    /*
     * @param : a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        
        int j = 0;
        int i = 0;
        int ans = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)] == 0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            map[s.charAt(i)] = 0;
        }
        
        return ans;
    }
}
