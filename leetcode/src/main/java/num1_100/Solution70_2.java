package num1_100;

/**
 * 70. 爬楼梯
 * 动态规划
 */
class Solution70_2 {
    // 用于记录爬到第n阶的方法数量
    int[] stairs;
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        stairs = new int[n + 1];
        stairs[1] = 1;
        stairs[2] = 2;
        for (int i = 3; i <= n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }

        return stairs[n];
        
    }
}