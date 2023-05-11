package num1_100;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 */
class Solution76 {
    public String minWindow(String s, String t) {
        // 分别用于记录目标最小子串的左边界和右边界
        int resultLeft = 0, resultRight = -1;

        int minLength = s.length() + 1;
        // 用于记录子串的左右边界
        int left = 0, right = -1;
        // 用于记录包含的字母个数
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charc = t.toCharArray();
        for (char aChar : charc) {
            map.put(aChar, map.containsKey(aChar) ? map.get(aChar) + 1 : 1);
        }
        char[] chars = s.toCharArray();
        while (right < s.length() && left < s.length()){
            if (count == t.length()){
                if (minLength > right - left){
                    minLength = right - left;
                    resultLeft = left;
                    resultRight = right;
                }

                if (map.containsKey(chars[left])){
                    if (map.get(chars[left]) == 0){
                        count--;
                    }
                    map.put(chars[left], map.get(chars[left]) + 1);
                }
                left++;
            } else {
                right++;
                if (right >= s.length()) {
                    break;
                }
                if (map.containsKey(chars[right])){
                    if (map.get(chars[right]) > 0) {
                        count++;
                    }
                    map.put(chars[right], map.get(chars[right]) - 1);
                }

            }
        }

        if(resultLeft == 0 && resultRight == -1){
            return "";
        }

        return s.substring(resultLeft, resultRight + 1);
    }


}