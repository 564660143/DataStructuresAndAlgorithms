package num1_100;

/**
 * 64. 最小路径和
 * 动态规划
 */
class Solution64_2 {
    int[][] result;
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        initResult(m, n);
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                result[i][j] = grid[i][j] + min(result, i, j + 1, i + 1, j);
            }
        }
        return result[0][0];
    }

    // 获取result中坐标{x1,y1},{x2,y2}中较小的一个
    // 存在一个点坐标越界时, 返回另外一个点的值
    // 存在两个点坐标越界时, 返回0
    private int min(int[][] result, int x1, int y1, int x2, int y2){
        int m = result.length;
        int n = result[0].length;
        // 点1越界
        if (x1 >= m || y1 >=n){
            // 点1点2同时越界
            if (x2 >= m || y2 >=n){
                return 0;
            } else {
                return result[x2][y2];
            }
        } else {
            if (x2 >= m || y2 >=n){
                return result[x1][y1];
            } else {
                return Math.min(result[x1][y1], result[x2][y2]);
            }
        }
    }

    private void initResult(int m, int n) {
        result = new int[m][n];
        for (int i = 0; i < result.length; i++) {
            result[i] = new int[n];
        }
    }
}