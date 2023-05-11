package num201_300;
import java.util.HashSet;

//给定一个整数数组，判断是否存在重复元素。
//如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

/**
 * 217. 存在重复元素
 */
class Solution217 {
    public boolean containsDuplicate(int[] nums) {
      HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            } else {
              set.add(nums[i]);
            }
        }
        return false;
    }
}