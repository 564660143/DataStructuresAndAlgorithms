package num501_600;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 * 566. 重塑矩阵
 * @author xuxiumeng
 *
 */
class Solution566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
      int rows = nums.length;
      int cols = nums[0].length;
      if (r * c == rows * cols) {
        int[][] newNums = new int[r][c];
        List<Integer> numList = new ArrayList<Integer>(rows * cols);
        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
            numList.add(nums[i][j]);
          }
        }
        
        int k = 0;
        for (int i = 0; i < r; i++) {
          newNums[i] = new int[c];
          for (int j = 0; j < c; j++) {
            newNums[i][j] = numList.get(k);
            k++;
          }
        }
        return newNums;
      } else {
        return nums;
      }
    }
}