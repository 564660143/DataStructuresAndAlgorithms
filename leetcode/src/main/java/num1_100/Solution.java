package num1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 15. 三数之和
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4){
            return result;
        }
        int first = 0, second = 1, third = 2;
        int sum = nums[first] + nums[second] + nums[third];
        int index = 0;
        while (first < nums.length && second < nums.length && third < nums.length){
            if (sum == 0){
                List<Integer> list = new ArrayList<>();
                list.add(nums[first]);
                list.add(nums[second]);
                list.add(nums[third]);
            }
            switch (index % 3){
                case 0:
            }

        }
        return result;
    }
}