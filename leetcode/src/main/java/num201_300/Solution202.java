package num201_300;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 */
class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true){
            n = getSquaresum(n);
            if (set.contains(n)){
                if (n == 1){
                    return true;
                } else {
                    return false;
                }
            } else {
                set.add(n);
            }
        }
    }

    /**
     * 获取一个数字各个位上的平方和
     * @param num
     * @return
     */
    private int getSquaresum(int num){
        int sum = 0;
        int temp;
        while (num != 0){
            temp = num % 10;
            sum += temp * temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        new Solution202().isHappy(19);
    }

}