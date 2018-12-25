package num1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 */
class Solution39 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1 || target < 0) {
            return result;
        }

        // 排序
        Arrays.sort(candidates);
        findTarget(candidates, target, 0, new ArrayList<>());

        return result;
    }

    // 从candidates的index位之后查找和为target的组合
    private void findTarget(int[] candidates, int target, int index, List<Integer> temp){
        if (target == 0) {
            result.add(new ArrayList<>(temp));
//            System.out.println("get a result" + temp);
            return;
        }

        for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
            temp.add(candidates[i]);
//            System.out.println("use : " + candidates[i] + " --  temp : " + temp);
            findTarget(candidates, target - candidates[i], i, temp);
            //
            temp.remove(temp.size() - 1);
        }
    }

//    public static void main(String[] args) {
//        new Solution39().combinationSum(new int[]{2, 3, 6, 7}, 7);
//    }

}