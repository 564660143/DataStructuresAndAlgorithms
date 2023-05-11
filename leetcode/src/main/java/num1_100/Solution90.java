package num1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 */
class Solution90 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return result;
        }
        // 排序
        Arrays.sort(nums);
        findSubset(nums, 0, new ArrayList<>());
        // 空集也是一个子集
        result.add(new ArrayList<>());
        return result;
    }

    private void findSubset(int[] nums, int index, List<Integer> temp){

        for (int i = index; i < nums.length; i++){
            // 去除重复元素
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            findSubset(nums, i + 1, temp);
            // 回溯
            temp.remove(temp.size() - 1);
        }
    }

}