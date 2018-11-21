package num1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 */
class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Too Big!!太大了，后续只能更大，可以直接结束循环；
            if (nums[i] * 4 > target) {
                break;
            }
            //Too Small！太小了，当前值不需要再算，可以继续循环尝试后面的值。
            if (nums[i] + 3 * nums[nums.length - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //Too Big！ 注意此时不能结束i的循环，因为j是移动的 当j移动到后面的时候继续i循环也sum可能变小
                if (nums[j] * 3 > target - nums[i]) {
                    break;
                }
                // Too Small
                if (nums[j] + 2 * nums[nums.length - 1] < target - nums[i]) {
                    continue;
                }

                int begin = j + 1;
                int end = nums.length - 1;
                while (begin < end) {
                    int sum = nums[i] + nums[j] + nums[begin] + nums[end];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[begin], nums[end]));
                        while (begin < end && nums[begin] == nums[begin + 1]) {
                            begin++;
                        }
                        while (begin < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        begin++;
                        end--;
                    } else if (sum < target) {
                        begin++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return res;
    }
}