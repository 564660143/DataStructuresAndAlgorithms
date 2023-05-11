package num1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 */
class Solution46 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        permute(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void permute(int[] nums, List<Integer> temp, boolean[] used) {

        for (int i = 0; i < nums.length; i++) {
            if (temp.size() == nums.length) {
                // 副本添加到result中
                result.add(new ArrayList<>(temp));
                return;
            }

            if (!used[i]) {
                temp.add(nums[i]);
                used[i] = true;
                permute(nums, temp, used);
                // 回溯
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }

    }
}