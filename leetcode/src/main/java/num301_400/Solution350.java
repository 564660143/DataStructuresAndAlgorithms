package num301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 */
class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = arrayToMap(nums1);
        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
                result.add(i);
            }
        }

        int[] arrResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arrResult[i] = result.get(i);
        }

        return arrResult;
    }

    /**
     * 将数组转为Map, 其中key为值, value为频次
     * @param nums
     * @return
     */
    private Map<Integer, Integer> arrayToMap(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        if (nums == null || nums.length == 0) {
            return map;
        }
        for (int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        return map;
    }
}