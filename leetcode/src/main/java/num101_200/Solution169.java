package num101_200;
import java.util.HashMap;
/**
 * 169. 求众数
 * @author xuxiumeng
 *
 */
class Solution169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        
        for(Integer num : map.keySet()){
            if(map.get(num) > n / 2){
                return num;
            }
        }
        return 0;
    }
}