package num401_500;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 * O(nlog)
 */
class Solution451 {
    private Random random = new Random();

    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        // 记录每个字符出现的频次, 数字下标为字符ASCII码, LeetCode这题的测试用例128已经够用了
        int[] freq = new int[128];
        // 遍历字符数组, 计算每个字符出现的频次, 这一步时间复杂度O(n)
        for (int i = s.length() - 1; i >= 0; i--) {
            freq[chars[i]]++;
        }

        // 对chars数组进行三路快排, 设定频次越高的字符值越大,频次相等时再按照字符ASCII码进行比较
        // 排序这一步时间复杂度为O(nlogn), 所以整个算法的时间复杂度是O(nlogn)
        quicksort3Ways(chars, 0, s.length() - 1, freq);
        // 排序完成之后
        return  new String(chars);
    }

    /**
     * 三路快排, 递归算法, 对chars数组的[l...r]前闭后闭区间进行排序
     * @param chars : 要排序的字符数组
     * @param l : 数组左边界
     * @param r : 数组右边界
     * @param freq : 字符出现频次, 设定字符大小与频次高低一致
     */
    private void quicksort3Ways(char[] chars, int l, int r, int[] freq){
        // 递归终止条件,只有一个元素时默认数组是有序的
        if (r - l < 1) {
            return;
        }

        // 选取标定点, 随机选取, 避免数组本身是有序的导致快排性能下降
        int pivotIndex = random.nextInt(r - l + 1) + l;
        swap(chars, l, pivotIndex);
        char pivot = chars[l];
        // 设定chars[l+1...left] < pivot, chars[left + 1, i) == pivot, chars[right, r] < pivot
        int left = l, right = r + 1, i = l + 1;
        while(i < right){
            // 大于pivot的元素
            if (compare(chars[i], pivot, freq) > 0) {
                swap(chars, left + 1, i);
                left++;
                i++;
            // 小于pivot的元素
            } else if (compare(chars[i], pivot, freq) < 0) {
                swap(chars, right - 1, i);
                // right - 1的元素还没有遍历, 所以这里只需要right--, 并不用i++
                right--;
            } else {
                i++;
            }

        }

        // chars[l]==pivot, 所以最后需要将l与left交换位置
        swap(chars, l , left);
        // 递归对小于pivot的元素再进行排序
        quicksort3Ways(chars, l, left, freq);
        // 递归对大于pivot的元素再进行排序
        quicksort3Ways(chars, right, r, freq);
    }

    public int compare(char c1, char c2, int[] freq) {
        if (freq[c1] == freq[c2]){
            return c1 - c2;
        }
        return freq[c1] - freq[c2];
    }

    /**
     * 对数组chars数组中index1,index2位置的两个元素进行交换
     * @param chars
     * @param index1
     * @param index2
     */
    private void swap(char[] chars, int index1, int index2){
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }

    public static void main(String[] args) {
        new Solution451().frequencySort("raaeaedere");
    }

}