package num601_700 ;

/**
 * LeetCode-695. 岛屿的最大面积
 * @author 七夜雪
 *
 */
class Solution695 {
    
    // 返回与点[i][j]相连的1的个数
    private int dfs(int[][] grid, int i, int j, int rows, int cols, int sum){
        if(grid[i][j] == 0){
            return sum;
        }
        
        grid[i][j] = 0;
        sum = sum + 1;
        // 上
        if(i - 1 >= 0){
            sum = dfs(grid, i - 1, j, rows, cols, sum);
        }
        
        // 下
        if(i + 1 < rows){
            sum = dfs(grid, i + 1, j, rows, cols, sum);
        }
        // 左
        if(j - 1 >= 0){
            sum = dfs(grid, i, j - 1, rows, cols, sum);
        }
        // 右
        if(j + 1 < cols){
           sum = dfs(grid, i, j + 1, rows, cols, sum); 
        }
        
        return sum;
    }
    
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, i, j, rows, cols, 0));
                }
            }
        }
        
        return maxArea;
    }
}