package num1_100 ;

/**
 * 26. 删除排序数组中的重复项
 * @author 七夜雪
 *
 */
class Solution26 {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;
        // [0...i]区间不包含重复元素, 遍历时每次对比nums[i]与nums[j]
        int i = 0, j = 1;
        for(; j < nums.length; j++){
            if(nums[j] != nums[i]){
                nums[i + 1] = nums[j];
                i++;
            }
        }

        return i + 1;
    }
}