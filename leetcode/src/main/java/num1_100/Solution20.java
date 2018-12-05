package num1_100;

import java.util.Stack;

/**
 * 20. 有效的括号
 */
class Solution20 {
    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if ('[' == chars[i] || '{' == chars[i] || '(' == chars[i]) {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                switch (chars[i]){
                    case ']':
                        if ('[' != stack.pop()) {
                            return false;
                        }
                        break;
                    case '}':
                        if ('{' != stack.pop()) {
                            return false;
                        }
                        break;
                    case ')':
                        if ('(' != stack.pop()) {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }

        }

        if (stack.isEmpty()) {
            return false;
        }
        return true;

    }

}