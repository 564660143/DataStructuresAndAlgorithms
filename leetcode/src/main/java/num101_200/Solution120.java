package num101_200;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 自底向上
 */
class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int[] result = new int[triangle.get(triangle.size() - 1).size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                result[j] = Math.min(result[j], result[j + 1]) + row.get(j);
            }
        }

        return result[0];
    }
}