package num201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 */
class Solution216 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        findN(k, n, 1, new ArrayList<>());
        return result;
    }

    // 在1~9中找k个数, 使其和为n, 其中数字不能重复
    private void findN(int k, int n, int index, List<Integer> temp) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i <= 9 && n >= index ; i++) {
            temp.add(i);
            findN(k - 1, n - i, i + 1, temp);
            // 回溯
            temp.remove(temp.size() - 1);
        }
    }

}