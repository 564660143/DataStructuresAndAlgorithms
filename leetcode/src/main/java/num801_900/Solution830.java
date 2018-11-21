package num801_900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 	830.较大分组的位置
 * 	双指针
 */
class Solution830 {
    private final static int BIG_GROUP = 3;

    public List<List<Integer>> largeGroupPositions(String S) {
        if (S.length() < 3) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        char[] chars = S.toCharArray();
        // 设定nums[start...end)区间的字符都相等
        int start = 0, end = 1;
        while (start < S.length() - 2 && end < S.length()){
            if (chars[start] == chars[end]){
                end++;
            } else {
                if (end - start >= BIG_GROUP){
                    result.add(Arrays.asList(start, end - 1));
                }
                start = end;
                end++;
            }
        }

        // 判断最后连续的字符是否为最大分组
        if (end - start >= BIG_GROUP){
            result.add(Arrays.asList(start, end - 1));
        }
        return result;
    }
}