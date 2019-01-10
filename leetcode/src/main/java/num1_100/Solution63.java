package num1_100;

/**
 * 63. 不同路径 II
 */
class Solution63 {
    int[][] result;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m < 1) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        result = new int[m][n];
        for (int i = 0; i < result.length; i++) {
            result[i] = new int[n];
        }
        // 填充最下面一行
        fillLastDown(obstacleGrid, m, n);
        // 填充最右侧一行
        fillRightDown(obstacleGrid, m, n);
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    // {i,j}这个点的路径数为下方模块的路径 + 右侧模块路径
                    // 最下面一行和最右边一行已经提前赋值了, 所以i + 1和j + 1肯定都是合法的
                    result[i][j] = result[i][j + 1] + result[i + 1][j];
                }
            }
        }

        return result[0][0];
    }

    // 填充最下面一行
    private void fillLastDown(int[][] obstacleGrid, int m, int n) {
        boolean obstacle = false;
        // 填充最下面一行
        for (int i = n - 1; i >= 0; i--) {
            // 如果已经出现障碍物了, 左侧的点路径均为0
            if (obstacle) {
                result[m - 1][i] = 0;
            } else {
                if (obstacleGrid[m - 1][i] == 1) {
                    obstacle = true;
                    result[m - 1][i] = 0;
                } else {
                    result[m - 1][i] = 1;
                }
            }
        }
    }

    // 填充最右面一行
    private void fillRightDown(int[][] obstacleGrid, int m, int n) {
        boolean obstacle = false;
        // 填充最右面一行
        for (int i = m - 1; i >= 0; i--) {
            // 如果已经出现障碍物了, 上方的点路径均为0
            if (obstacle) {
                result[i][n - 1] = 0;
            } else {
                if (obstacleGrid[i][n - 1] == 1) {
                    obstacle = true;
                    result[i][n - 1] = 0;
                } else {
                    result[i][n - 1] = 1;
                }
            }
        }
    }

}