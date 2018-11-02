package num1_100;

/**
 * LeetCode-27. 移除元素
 * @author xuxiumeng
 *
 */
class Solution27 {
    public int removeElement(int[] nums, int val) {
        // 其实就是根据快速排序的方式进行一次partition操作即可, 只是把元素分为不等于val和等于val的两部分
        // 设定[0,l]区间所有元素均不等于val,[l+1,i)区间元素等于val, l初始化化为-1, i初始化为0, 初始状态两个条件都满足设定
        // 遍历数组,进行partition操作
        int l = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                // i==l+1时不需要交换位置,只需要l++即可, 否则l+1和i交换位置保障[0,l],[l+1,i)两个区间的特性
                if(i != l + 1){
                    int temp = nums[l + 1];
                    nums[l + 1] = nums[i];
                    nums[i] = temp;
                }
                l++;
            }
        }
        return l + 1;
    }
}