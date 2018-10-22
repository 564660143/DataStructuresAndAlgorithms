package num801_900;

//867. 转置矩阵
//给定一个矩阵 A， 返回 A 的转置矩阵。
//矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
class Solution867 {
    // 行列互换即可
    public int[][] transpose(int[][] A) {
        int cols = A.length;
        int rows = A[0].length;
        int[][] newArr = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            newArr[i] = new int[cols];
            for(int j = 0; j < cols; j++){
                newArr[i][j] = A[j][i];
            }
        }
        
        return newArr;
    }
}