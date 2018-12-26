package num1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 */
class Solution78 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return result;
        }
        findSubset(nums, 0, new ArrayList<>());
        // 空集也是一个子集
        result.add(new ArrayList<>());
        return result;
    }

    // 在nums中从index位置开始, 查找后面的所有子集, temp保存的index之前的结果集
    private void findSubset(int[] nums, int index, List<Integer> temp) {
        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            findSubset(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

}