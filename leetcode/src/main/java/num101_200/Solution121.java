package num101_200;
/**
 * LeetCode-121. 买卖股票的最佳时机
 * @author xuxiumeng
 *
 */
class Solution121 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length < 2){
            return 0;
        }
        // 记录[0..i]区间的最大利润
        int maxProfit = 0;
        // 记录[0..i]区间的最小价格
        int minPrice = prices[0];
        for(int i = 1; i < length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        
        return maxProfit;
    }
}