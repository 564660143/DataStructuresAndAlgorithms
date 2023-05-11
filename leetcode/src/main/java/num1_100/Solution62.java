package num1_100;

import java.util.Arrays;

/**
 *  62. 不同路径
 *  动态规划, 状态转移方程, 当前点的路径数 = 下方的路径 + 右侧的路径
 *  边界就是, 最下方和最右方的路径数都为1
 */
class Solution62 {
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[][] result = new int[m][n];
        Arrays.fill(result, new int[n]);
        // 最下面一行都只有一条路径 : 一直向右
        Arrays.fill(result[m - 1], 1);
        result[m - 1][n - 1] = 1;
        for (int i = m - 2; i >= 0; i--) {
            // 最右边一行也都只有一条路径 : 一直向下
            result[i][n - 1] = 1;
            for (int j = n - 2; j >= 0; j--) {
                // {i,j}这个点的路径数为下方模块的路径 + 右侧模块路径
                // 最下面一行和最右边一行已经提前赋值了, 所以i + 1和j + 1肯定都是合法的
                result[i][j] = result[i][j + 1] + result[i + 1][j];
            }
        }

        return result[0][0];
    }
}