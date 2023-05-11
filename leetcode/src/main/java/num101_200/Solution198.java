package num101_200;

/**
 * 198. 打家劫舍
 * 动态规划
 */
class Solution198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        // result[i]表示偷取[0...i]范围内的最大价值
        int[] result = new int[nums.length + 1];
        result[0] = 0;
        result[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 状态转移方程 f(i) = Max(f(i - 1), f(i - 2) + nums[i])
            result[i + 1] = Math.max(result[i - 1] + nums[i], result[i]);
        }

        return result[nums.length];
    }
}