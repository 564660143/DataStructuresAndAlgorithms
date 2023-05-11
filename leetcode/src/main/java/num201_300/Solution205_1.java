package num201_300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 205. 同构字符串
 */
class Solution205_1 {
    public boolean isIsomorphic(String s, String t) {
        // 用于存储s->t的字符映射关系
        Map<Character, Character> map = new HashMap<>();
        // 用于存储t中的字符
        Set<Character> tSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                if (!map.get(s.charAt(i)).equals(t.charAt(i))){
                   return false;
                }
            } else {
                // 如果map中不包含s.charAt(i)->t.charAt(i)的映射, 而tSet中已经包含了t.charAt(i)
                // 则说明s->t的映射存在多对一的情况, 直接返回false
                if (tSet.contains(t.charAt(i))) {
                    return false;
                }
                tSet.add(t.charAt(i));
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        return true;
    }
}