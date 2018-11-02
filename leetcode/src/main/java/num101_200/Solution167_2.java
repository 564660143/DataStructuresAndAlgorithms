package num101_200;

/**
 * 167. 两数之和 II - 输入有序数组
 * 双指针
 * @author xuxiumeng
 *
 */
class Solution167_2 {
        
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while(l < r){
            if(numbers[l] + numbers[r] == target){
                return new int[]{l + 1, r + 1};
            } else if(numbers[l] + numbers[r] < target){
                l ++;
            } else{
                r --;
            } 
        }
        
      return null;      
    }
}