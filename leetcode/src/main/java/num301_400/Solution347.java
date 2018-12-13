package num301_400;

import java.util.*;

/**
 * 347. 前K个高频元素
 */
class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return  Collections.emptyList();
        }
        Map<Integer, Integer> map = new HashMap<>();
        // 将数组保存到Map中, key是值, value为频次
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> {
            return o1.getValue() - o2.getValue();
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else {
                if (entry.getValue() > queue.peek().getValue()) {
                    queue.poll();
                    queue.add(entry);
                }
            }
        }
        Integer[] result = new Integer[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return Arrays.asList(result);
    }

}