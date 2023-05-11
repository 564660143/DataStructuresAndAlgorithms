package num101_200;

/**
 * 200. 岛屿的个数
 */
class Solution200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    sum += 1;
                    oneToZero(grid, i, j);
                }
            }
        }

        return sum;
    }

    // 将grid中所有与grid[x][y]相连的点全部置为0
    private void oneToZero(char[][] grid, int row, int col){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        oneToZero(grid, row + 1, col);
        oneToZero(grid, row - 1, col);
        oneToZero(grid, row, col + 1);
        oneToZero(grid, row, col - 1);
    }


}