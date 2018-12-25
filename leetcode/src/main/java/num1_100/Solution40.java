package num1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 */
class Solution40 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1 || target < 0) {
            return result;
        }

        // 排序
        Arrays.sort(candidates);
        findTarget(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void findTarget(int[] candidates, int target, int index, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
//            System.out.println("get a result" + temp);
            return;
        }

        for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
            // 剔除重复元素
            if (i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
            temp.add(candidates[i]);
//            System.out.println("index :" + i +  "--use : " + candidates[i] + " --  temp : " + temp);
            findTarget(candidates, target - candidates[i], i + 1, temp);
            // 回溯
            temp.remove(temp.size() - 1);
        }
    }

//    public static void main(String[] args) {
//        new Solution40().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
//    }

}