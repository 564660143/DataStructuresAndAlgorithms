package num401_500;
import java.lang.Math;

/**
 * leetcode-485. 最大连续1的个数
 * @author xuxiumeng
 *
 */
class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int tempMax = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                tempMax++;
            } else if(tempMax != 0){
                max = Math.max(max, tempMax);
                tempMax = 0;
            }
        }
         max = Math.max(max, tempMax);
        return max;
    }
}