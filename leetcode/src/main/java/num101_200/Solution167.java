package num101_200;

/**
 * 167. 两数之和 II - 输入有序数组
 * @author xuxiumeng
 *
 */
class Solution167 {
    
    // 二分查找, 在numbers[l..r]的区间查找值为target的元素, 返回下标索引, 找不到符合条件的元素返回-1
    private int bs(int[] numbers, int target, int l, int r){
        if(l > r){
            return -1;
        }
        
        if(l == r){
            if(numbers[l] == target){
              return r;
            } else {
              return -1;
            }
            
        }
        
        int mid = (r - l ) / 2 + l;
        if(target == numbers[mid]){
            return mid;
        } else if (target < numbers[mid]){
            return bs(numbers, target, l, mid - 1);
        } else {
            return bs(numbers, target, mid + 1, r);
        }
        
    }
    
    public int[] twoSum(int[] numbers, int target) {
        int[] indexs = new int[2];
        for(int i = 0; i < numbers.length; i++){
            int tempTarget = target - numbers[i];
            int secondIndex = bs(numbers, tempTarget, i + 1, numbers.length - 1);
            if(secondIndex != -1){
                indexs[0] = i + 1;
                indexs[1] = secondIndex + 1;
                break;
            } 
        }
        
      return indexs;      
    }
}