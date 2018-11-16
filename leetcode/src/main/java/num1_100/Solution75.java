package num1_100;

/**
 * 75. 颜色分类
 * @author 七夜雪
 *
 */
class Solution75 {
    /**
     * 双指针
     */
    public void sortColors(int[] nums) {
        int l = -1; // 设定[0...l]区间为0, [l + 1...i)前闭后开的区间为1, i表示遍历中要考察的元素
        int r = nums.length; // [r...nums.length)前闭后开的区间值为2
        int i = 0;
        while(i < r){
            if(nums[i] == 0){
                l++;
                nums[l] = 0;
                // l == r的这种情况不需要进行交换
                if(l != i){
                    nums[i] = 1;
                }
                i++;
                
            } else if(nums[i] == 1){
                i++;
            } else {
                r--;
                nums[i] = nums[r];
                nums[r] = 2;
            }
        }
        
    }
}