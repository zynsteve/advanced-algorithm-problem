package followUpInCodeInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring T
 * that contains at most k distinct characters.
 * 
 * Example
 * For example, Given s = "eceba", k = 3, T is "eceb" which its length is 4.
 */

public class LongestSubstringWithAtMostKDistinctCharacters {
    /*
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i, j = 0;
        char c;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    if(map.size() == k) {
                        break;
                    }
                    map.put(c, 1);
                }
                j++;
            }
      
            maxLen = Math.max(maxLen, j - i);
            c = s.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                if (count > 1) {
                    map.put(c, count - 1);
                } else {
                    map.remove(c);
                }
            }
        }
        return maxLen; 
    }
}
