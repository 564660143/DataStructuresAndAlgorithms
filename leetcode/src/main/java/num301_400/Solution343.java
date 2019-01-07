package num301_400;

/**
 *  343. 整数拆分
 *  拆出的3越多乘积越大, 剩余为4时拆成2 * 2时值最大, 所以4不需要拆分
 *  参考 : https://blog.csdn.net/liyuanbhu/article/details/51198124
 */
class Solution343 {
    public int integerBreak(int n) {
       if (n == 2) {
           return 1;
       }
       if (n == 3) {
           return 2;
       }
       int result = 1;
       // n = 4 时拆分的最大值为2 * 2
       while (n > 4) {
           result = result * 3;
           n = n - 3;
       }

       return result * n;
    }
}