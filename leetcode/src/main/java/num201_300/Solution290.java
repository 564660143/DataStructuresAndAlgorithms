package num201_300;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 290. 单词模式
 */
class Solution290 {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()){
            return  false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(pattern.charAt(i))){
                if (!map.get(pattern.charAt(i)).equals(words[i])){
                    return false;
                }
            } else {
                // 表示如果出现重复单词, 则不符合, 这里因为LeetCode上面测试数据量都不大, 直接就用containsValue的方法判断了
                // containsValue的时间复杂度是O(n), 数据量大的情况下, 可以使用HashSet存储已经出现过的单词
                // 然后使用Set的contains方法进行判断, contains方法的时间复杂度是O(1)的
                if (map.containsValue(words[i])){
                    return false;
                }
                map.put(pattern.charAt(i), words[i]);
            }

        }

        return true;
    }
}