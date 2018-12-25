package num1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 */
class Solution77 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || n < k) {
            return result;
        }
        combine(n, k, 1, new ArrayList<>());
        return result;
    }

    private void combine(int n, int k, int index, List<Integer> temp) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // i <= n - k + 1这步优化, 是因为当剩余的不足k个元素时, 就不需要进行遍历了
        for (int i = index; i <= n - k + 1; i++) {
            temp.add(i);
            combine(n, k - 1, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

}