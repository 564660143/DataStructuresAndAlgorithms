package num401_500 ;

import java.util.ArrayList ;
import java.util.List ;

/**
 * 448. 找到所有数组中消失的数字
 * @author 七夜雪
 *
 */
class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> indexs = new ArrayList<>();
        int m;
        for(int i = 0; i < nums.length; i++){
            m = Math.abs(nums[i]) - 1;
            if(nums[m] > 0){
                nums[m] = -nums[m];
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
               indexs.add(i + 1);
            }
        }
        
        return indexs;
    }
}