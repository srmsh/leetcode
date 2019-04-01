package longestSubstring;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        StringBuilder tmp = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char o = s.charAt(i);
            if (tmp.indexOf(String.valueOf(o))== -1) {
                tmp.append(o);
                count = Math.max(count, tmp.length());
            } else {
                tmp.delete(0, tmp.indexOf(String.valueOf(o)) + 1);
                tmp.append(o);
            }
        }
        return count;
    }

}
