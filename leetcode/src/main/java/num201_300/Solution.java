package num201_300;

import java.util.TreeMap;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeMap<Long, Integer> map = new TreeMap<>();
        for (int i = 0; i < k && i < nums.length ; i++) {
            map.put((long)nums[i], map.getOrDefault((long)nums[i], 0) + 1);
        }

        if(k == 0) {
            return false;
        }
        if (map.ceilingKey(map.firstKey()) - map.firstKey() > t) {
            return false;
        }

        int l = 1, r = k;
        while (r < nums.length){
            map.put((long)nums[r], map.getOrDefault((long)nums[r], 0) + 1);
            if (map.getOrDefault((long)nums[l - 1], 0) > 1) {
                map.put((long)nums[l - 1], map.get((long)nums[l - 1]) - 1);
            } else {
                map.remove((long)nums[l - 1]);
            }
            if (map.lastKey() - map.firstKey() > t) {
                return false;
            }
            l++;
            r++;
        }

        return true;
    }

}