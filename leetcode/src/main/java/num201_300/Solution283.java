package num201_300;
/**
 * LeetCode-283. 移动零
 * @author xuxiumeng
 *
 */
class Solution283 {
  public void moveZeroes(int[] nums) {
      int nonZeroIndex = -1;
      for(int i = 0; i <nums.length; i++){
          if(nums[i] != 0){
              if(nonZeroIndex + 1 != i){
                  nums[nonZeroIndex + 1] = nums[i];
              }
               nonZeroIndex++;
          }
      }
      
      for(int i = nonZeroIndex + 1; i < nums.length; i++){
          nums[i] = 0;
      }
      
  }
}