package num401_500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 */
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        // 用于标识这个
        int count = p.length();
        List<Integer> result = new ArrayList<>();
        if(s.length() < count){
            return result;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = p.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.containsKey(aChar) ? map.get(aChar) + 1 : 1);
        }

        char[] sChars = s.toCharArray();
        // 用s串的[left, right]表示p的异位词, 当count为0时表示是异位词
        int left = 0, right = -1;

        while (right < s.length() && left < s.length() - p.length() + 1){
            if (right - left == p.length() - 1){
                if (count == 0){
                    result.add(left);
                }
                count = moveLeft(sChars, map, left, count);
                left++;
            }
            count = moveRight(sChars, map, right, count);
            right++;

        }

        return result;
    }


    // left右移一位
    private int moveLeft(char[] sChars, HashMap<Character, Integer> map, int left, int count){
        if (map.containsKey(sChars[left])){
            if (map.get(sChars[left]) >= 0){
                count++;
            }
            map.put(sChars[left], map.get(sChars[left]) + 1);
        }

        return count;
    }

    // right右移一位, 返回count的值
    private int moveRight(char[] sChars, HashMap<Character, Integer> map, int right, int count){
        if (right + 1 > sChars.length - 1) {
            return  count;
        }
        if (map.containsKey(sChars[right + 1])){
            if (map.get(sChars[right + 1]) > 0){
                count--;
            }
            map.put(sChars[right + 1], map.get(sChars[right + 1]) - 1);
        }
        return count;
    }

}