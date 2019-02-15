package num301_400;

import java.util.Arrays;

/**
 * 303. 区域和检索 - 数组不可变
 */
class NumArray {
    private int[] result;
    public NumArray(int[] nums) {
        result = new int[nums.length + 1];
        result[0] = 0;
        for(int i = 1; i <= nums.length; i++){
            result[i] = nums[i - 1] + result[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return result[j + 1] - result[i];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(Arrays.toString(numArray.result));
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */