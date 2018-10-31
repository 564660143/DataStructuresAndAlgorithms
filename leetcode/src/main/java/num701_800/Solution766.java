package num701_800;
/**
 * 766. 托普利茨矩阵
 * @author xuxiumeng
 *
 */
class Solution766 {
    private static boolean check(int[][] matrix, int row, int col){
        if(matrix[row - 1][col] == matrix[row][col + 1]){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 1; i < rows; i++){
            for(int j = 0; j < cols - 1; j++){
                if(!check(matrix, i, j)){
                    return false;
                }
            }
        }
        return true;
    }
}