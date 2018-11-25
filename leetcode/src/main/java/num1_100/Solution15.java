package num1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {  // 跳过可能重复的答案

                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            // 跳过重复值
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            // 跳过重复值
                            r--;
                        }
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) {
                            // 跳过重复值
                            l++;
                        }
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) {
                            // 跳过重复值
                            r--;
                        }
                        r--;
                    }
                }
            }
        }
        return ls;
    }
}