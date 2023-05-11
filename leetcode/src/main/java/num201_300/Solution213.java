package num201_300;

/**
 * 213. 打家劫舍 II
 */
class Solution213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        if (nums.length == 1){
            return nums[0];
        }

        // 分为偷取nums[0]和不偷取nums[0]两种情况, 偷取nums[0]时, 则不能偷取nums[n - 1]
        return Math.max(tryRob(nums, 0, nums.length - 2), tryRob(nums, 1, nums.length - 1));
    }

    // 尝试偷取nums[l...r]范围内区间, l和r不会同时为0,nums.length - 1
    private int tryRob(int[] nums, int l, int r){
        if (r < l) {
            return 0;
        } else if (r == l ){
            return nums[l];
        }
        int[] result = new int[r + 1];
        result[l] = nums[l];
        result[l + 1] = Math.max(nums[l], nums[l + 1]);
        for (int i = l + 2; i <= r; i++) {
            result[i] = Math.max(result[i - 2] + nums[i], result[i - 1]);
        }
        return result[r];
    }

}