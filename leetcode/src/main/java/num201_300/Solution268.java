package num201_300;
/**
 * 268. 缺失数字
 * @author xuxiumeng
 *
 */
class Solution268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            n = n + i - nums[i];
        }
        return n;
    }
}