package longestPalindromicSubstring;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class Solution {

    public String longestPalindrome(String s) {

        if (null == s || s.length() < 1) {
            return "";
        }

        int length = s.length();

        int start = 0,end = 0;

        for (int i = 0; i < length && i + (end - start)/2 < length; i++) {
            int palindromicLength = Math.max(findPalindromic(s, i, i), findPalindromic(s, i, i + 1));
            if (palindromicLength > end - start) {
                start = i - (palindromicLength - 1)/2;
                end = i + palindromicLength/2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int findPalindromic(String s, int start, int end){
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

}
