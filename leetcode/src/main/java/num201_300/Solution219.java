package num201_300;

/**
 * 219. 存在重复元素 II
 */
class Solution219 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    for (int i = 1; i < nums.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if(nums[i]>nums[j]) {
          break;
        } else if (nums[i] == nums[j]) {
          if((i-j)<=k) {
            return true;
          }
        }
      }
    }
    return false;
  }
}