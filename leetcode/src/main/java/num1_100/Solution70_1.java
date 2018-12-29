package num1_100;

/**
 * 70. 爬楼梯
 * 记忆化搜索
 */
class Solution70_1 {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n + 1];
        return calcStairs(n);
    }

    private int calcStairs(int n){
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // 避免重复计算, 将计算结果记录下来
        if (memo[n] == 0) {
            memo[n] = calcStairs(n);
        }
        return memo[n];
    }
}