package num201_300;

/**
 * 209.长度最小的子数组
 * 双指针 : 滑动窗口
 *
 */
class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        int min = nums.length + 1;
        // 设定nums数组的[l...r]区间元素之和大于等于s
        int l = 0, r = -1;
        int sum = 0;
        while (l < nums.length) {
            if (sum < s){
                if (r == nums.length - 1){
                    break;
                }
                sum += nums[r + 1];
                r++;
            } else {
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }

        if (min == nums.length + 1) {
            return 0;
        }

        return min;
    }

}