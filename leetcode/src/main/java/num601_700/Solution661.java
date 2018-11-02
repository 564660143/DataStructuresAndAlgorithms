package num601_700;

/**
 * 661. 图片平滑器
 * @author xuxiumeng
 *
 */
class Solution661 {
    private int getAverage(int[][] M, int row, int col, int l, int r){
        int sum = M[l][r];
        int count = 1;
        // 左上M[l-1][r-1]
        if(l - 1 >= 0 && r -1 >= 0){
            sum+=M[l-1][r-1];
            count++;
        }
        // 上中M[l-1][r]
        if(l - 1 >= 0){
            sum+=M[l-1][r];
            count++;
        }
        
        // 右上M[l-1][r+1]
        if(l - 1 >= 0 && r + 1 < col){
            sum+=M[l-1][r+1];
            count++;
        }
        
        // 左中M[l][r-1]
        if(r - 1 >= 0){
            sum+=M[l][r-1];
            count++;
        }
        
        // 右中M[l][r+1]
        if(r + 1 < col){
            sum+=M[l][r+1];
            count++;
        }
        
        // 左下M[l+1][r-1]
        if(l + 1 < row && r - 1 >= 0){
            sum+=M[l+1][r-1];
            count++;
        }
        
        // 下中M[l+1][r]
        if(l + 1 < row){
            sum+=M[l+1][r];
            count++;
        }
        
        // 右下M[l + 1][r + 1]
        if(l + 1 < row && r + 1 < col){
            sum+=M[l+1][r + 1];
            count++;
        }
        return sum / count;
    }
    
    public int[][] imageSmoother(int[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        int [][] newM = new int[rows][cols];
        for(int i = 0; i < rows; i++){
           for(int j = 0; j < cols; j++){
                newM[i][j] = getAverage(M, rows, cols, i, j);
           }
        }
        return newM;
    }
}