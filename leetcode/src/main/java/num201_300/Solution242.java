package num201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 */
class Solution242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = strToMap(s);
        if (s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i)) && map.get(t.charAt(i)) > 0){
                map.put(t.charAt(i), map.get(t.charAt(i))  - 1);
            } else {
                return false;
            }
        }

        return true;
    }


    /**
     * 字符串转换为Map, 其中key为字符, value为频次
     * @param str
     * @return
     */
    private Map<Character, Integer> strToMap(String str){
        Map<Character, Integer> map = new HashMap<>();
        if (str == null || "".equals(str)) {
            return map;
        }

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.containsKey(str.charAt(i)) ? map.get(str.charAt(i)) + 1 : 1);
        }

        return map;
    }

    public static void main(String[] args) {
        new Solution242().isAnagram("anagram", "nagaram");
    }
}