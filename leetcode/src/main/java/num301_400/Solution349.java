package num301_400;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 349. 两个数组的交集
 */
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)){
                set2.add(i);
            }
        }

        int[] result = new int[set2.size()];
        int i = 0;
        for (Integer integer : set2) {
            result[i] = integer;
            i++;
        }

        return result;
    }
}