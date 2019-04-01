package twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> targetMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            if (targetMap.containsKey(r)) {
                return new int[] {targetMap.get(r), i};
            }
            targetMap.put(nums[i], i);
        }
        return null;
    }

}
