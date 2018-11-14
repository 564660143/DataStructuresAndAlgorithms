package num1_100;

/**
 * 35.搜索插入位置
 * 二分搜索
 * @author xuxiumeng
 *
 */
class Solution35 {
  public int searchInsert(int[] nums, int target) {
      if(nums.length < 100){
          for (int i = 0; i < nums.length; i++)
          if (nums[i] >= target)
              return i;
          return nums.length;
      }
      int index = findIndex(nums, 0, nums.length - 1, target);
      return index;
  }
  
  
  private int findIndex(int[] nums, int left, int right, int target){
       if(target > nums[right]){
          return right + 1;
      }
      if(target < nums[left]){
          return left;
      }
      if(right == left){
          return right;
      }
      int mid = (right - left + 1) / 2 + left;
      if(target == nums[mid]){
          return mid;
      } else if (target > nums[mid]){
          return findIndex(nums, mid + 1, right, target);
      } else {
          return findIndex(nums, left, mid - 1, target);
      }
      
  }
  
}