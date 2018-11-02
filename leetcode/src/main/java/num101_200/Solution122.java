package num101_200;

/**
 * LeetCode-122. 买卖股票的最佳时机 II
 * @author xuxiumeng
 *
 */
class Solution122 {
    private int getMaxPrefix(int[] nums, int index){
        // 递归终止条件
        if(index <= 0){
            return 0;
        }
        // 当前的最大利润=昨天到今天到利润+截止到昨天的最大利润
        int preDayMaxPrefix = getMaxPrefix(nums, index - 1);
        if(nums[index] > nums[index -1]){
            return nums[index] - nums[index -1] + preDayMaxPrefix;
        }
        
        return preDayMaxPrefix;
    }
    
    public int maxProfit(int[] prices) {
        return getMaxPrefix(prices, prices.length - 1);
    }
}