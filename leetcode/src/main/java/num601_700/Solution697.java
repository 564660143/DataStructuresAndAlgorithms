package num601_700;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  697.数组的度
 * @author xuxiumeng
 *
 */
class Solution697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> maxSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
        
        int maxDegree = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int value = entry.getValue();
            if(value == maxDegree){
                maxSet.add(entry.getKey());
            } else if (value > maxDegree) {
                maxDegree = value;
                maxSet.clear();
                maxSet.add(entry.getKey());
            }
        }
        
        
        int minLength = 0;
        for(int num : maxSet){
            int left = 0;
            int right = nums.length - 1;
            for(; left < right; left++){
                if(nums[left] == num){
                    break;
                }
            }
            
            for(; right > left; right--){
                if(nums[right] == num){
                    break;
                }
            }
            
            if (minLength == 0) {
                minLength = right - left + 1;
            } else {
                minLength = Math.min(right - left + 1, minLength);
            }
            
        }
        
        return minLength;
    }
}