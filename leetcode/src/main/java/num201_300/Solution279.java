package num201_300;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * 参考 : https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51584790
 */
class Solution279 {
    public int numSquares(int n) {
        // 用于记录第i个数可以用多少个完全平方数表示
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);

        for (int i = 0; i * i <= n; i++) {
            // 数字本身为完全平方数时, 结果为1
            result[i * i] = 1;
        }

        // 普通数字可以认为是一个数字+一个完全平方数, 选定普通数字为i
        for (int i = 1; i <= n; i++) {
            // 选择完全平方数为j, 从小到大查找
            for (int j = 1; i + j * j <= n; j++) {
                result[i + j * j] = Math.min(result[i] + 1, result[i + j * j]);
            }
        }

        return result[n];
    }
}