package num101_200;

/**
 * 134. 加油站
 * 算法关键 : 如果gas数组之和大于cost数组之和, 则一定有解
 */
class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 剩余汽油
        int remain = 0;
        // 开始站点
        int start = 0;
        // 总汽油
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                // 如果剩余油量已经小于0了,说明从start到i的节点都不能作为起始节点
                // 比如从start+1开始查找,从start到start+1之后, 剩余汽油应该至少为0
                // 现在去掉从start到start+1之后剩余的油量, 肯定更不够了
                // 依次类推, 所以直接从i+1继续寻找就可以了
                start = i + 1;
                sum = sum + remain;
                remain = 0;
            }
        }

        return remain + sum < 0 ? -1 : start;
    }
}