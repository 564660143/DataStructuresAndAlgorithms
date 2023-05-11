package num1_100;

/**
 * 80. 删除排序数组中的重复项 II
 * @author 七夜雪
 *
 */
class Solution80 {
    public int removeDuplicates(int[] nums) {
        // 遍历过程中保证[0...i]中每个元素最多出现两次
        int i = 0, j = 1;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                if(i == 0 || nums[i - 1] != nums[i]){
                    nums[i + 1] = nums[j];
                    i++;
                }
                j++;
                
            } else {
                nums[i + 1] = nums[j];
                i++;
                j++;
                
            }
        }
		
        return i + 1;
    }
}
