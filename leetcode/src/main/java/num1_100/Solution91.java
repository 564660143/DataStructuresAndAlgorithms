package num1_100;

/**
 * 91. 解码方法
 */
class Solution91 {
    public int numDecodings(String s) {
        int n = s.length();
        // result[i] 表示字符串s的[i...s.length - 1)部分的解码结果数
        int[] result = new int[n + 1];
        char[] chars = s.toCharArray();
        // 用于辅助倒数第二位的计算
        result[n] = 1;
        // 以0开始的字符串无法进行解码
        if (chars[n - 1] != '0'){
            result[n - 1] = 1;
        }

        // 从后往前进行解码, f(n) = f(n + 1) + f(n + 2)
        // chars[n] == '0'时 f(n) = 0
        // chars[n],chars[n + 1]组成的数字大于26时f(n) = f(n + 1)
        for (int i = n - 2; i >= 0; i--) {
            // 如果当前位为0, 则结果为0 ,不需要进行解码
            if (chars[i] != '0') {
                if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    result[i] = result[i + 1] + result[i + 2];
                } else {
                    result[i] = result[i + 1];
                }
            }
        }

        return result[0];
    }
}