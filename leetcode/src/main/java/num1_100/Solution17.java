package num1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 */
class Solution17 {
    private static char[][] NUM_CHAR = new char[][]{
            null,
            null,
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) {
            return result;
        }
        letterCombinations(digits, 0, "");
        return result;
    }

    private void letterCombinations(String digits, int index, String temp){
        if (index > digits.length()) {
            return;
        }
        char[] chars = NUM_CHAR[digits.charAt(index) - '0'];
        if (index == digits.length() - 1) {
            for (char aChar : chars) {
                result.add(temp + aChar);
            }
        } else {
            for (char aChar : chars) {
                letterCombinations(digits, index + 1, temp + aChar);
            }
        }
    }

    public static void main(String[] args) {
        new Solution17().letterCombinations("23");
    }

}