package num1_100;

/**
 * 64. 最小路径和
 * 记忆化搜索
 */
class Solution64_1 {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        initMemo(m, n);
        return minPathSum(grid, 0, 0);
    }

    private int minPathSum(int[][] grid, int x, int y) {
        if (x >= grid.length || y >= grid[0].length) {
            return 0;
        }
        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        // {x,y}点的最小路径 = grid[x][y] + 左右侧节点路径的最小值
        // 右侧节点路径最小值
        int right = 0;
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            memo[x][y] = grid[x][y];
        } else if (x == grid.length - 1) {
            memo[x][y] = grid[x][y] + minPathSum(grid, x, y + 1);
        } else if (y == grid[0].length - 1) {
            memo[x][y] = grid[x][y] + minPathSum(grid, x + 1, y);
        } else {
            memo[x][y] = grid[x][y] + Math.min(minPathSum(grid, x + 1, y), minPathSum(grid, x, y + 1));
        }

        return memo[x][y];
    }

    private void initMemo(int m, int n) {
        memo = new int[m][n];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = new int[n];
        }
    }

}