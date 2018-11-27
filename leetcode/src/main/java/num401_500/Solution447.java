package num401_500;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量
 */
class Solution447 {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {

            for (int j = 0; j < points.length; j++) {
                // 不考虑当前同样的点
                if (i != j){
                    int distance = getDistance(points[i], points[j]);
                    map.put(distance,  map.getOrDefault(distance, 0) + 1);
                }
            }
            result += getCountByPoint(map);
            map.clear();
        }

        return result;
    }

    /**
     * 求两点之间的距离的平方, 不进行平方根操作了, 不然可能会涉及到浮点数问题
     * @param pointA
     * @param pointB
     * @return
     */
    private int getDistance(int[] pointA, int[] pointB){
        int x = pointA[0] - pointB[0];
        int y = pointA[1] - pointB[1];
        return x * x + y * y;
    }

    /**
     * 根据点的数量返回回旋镖的数量
     * @return
     */
    private int getCountByPoint(Map<Integer, Integer> map){
        int result = 0;
        for (Integer value : map.values()) {
            if (value > 1) {
                // 从n个点中选取两个点的方案数量为(n * n - 1)
                result += value * (value - 1);
            }
        }
        return  result;
    }
}