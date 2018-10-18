package sort.quick;

import java.util.Random;

import sort.Sort ;
import utils.ArrayUtil ;


/**
 * 快速排序优化
 * 上面两个版本的快速排序, 在处理近乎有序的数组的时候,性能很差, 
 * 因为每次partition时都取队首元素, 在数组近乎有序的时候, 会导致partition的两部分很不均匀
 * 在数组完全有序的情况下, 快速排序甚至会退化成O(n²)算法
 * 优化方案 : 每次随机取一个元素, 而不是每次取第一个元素
 * @author xuxiumeng
 *
 */
public class QuickSort3 implements Sort {
  private static Random random = new Random();
  
    @Override
    public void sort(int [] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    /**
     * 对数组arr的[l, r]前闭后闭的区间进行快速排序
     * 递归方法
     * @param arr
     * @param l
     * @param r
     */
    private void quickSort(int [] arr, int l, int r){
        // 递归终止条件
        if ( r - l < 16) {
            ArrayUtil.insertSort(arr, l, r);
            return;
        }
        
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }
    
    /**
     * 对arr数组的前闭后闭区间[l, r]进行partition操作
     * @param arr
     * @param l
     * @param r
     * @return 返回分割后作为标记元素的下标位置
     */
    private int partition(int [] arr, int l, int r){
        // 获取用于对比的随机元素下标
        int randomNum = random.nextInt(r - l) + l;
        ArrayUtil.swap(arr, l, randomNum);
        // 设置用于对比的元素为arr[l]
        int v = arr[l];
        // arr[l + 1, j] <v; arr[j+1, i)>v
        int j = l;
        for (int i = l; i <= r; i++) {
            if (arr[i] < v) {
                ArrayUtil.swap(arr, i, j + 1);
                j++;
            }
        }
        ArrayUtil.swap(arr, l, j);
        return j;
    }
    
}
