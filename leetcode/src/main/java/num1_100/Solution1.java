package num1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length -1; i >= 0; i--) {
            int firstNum = target - nums[i];
            if (map.containsKey(firstNum)) {
                return new int[]{i, map.get(firstNum)};
            } else {
                map.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException();
    }
}