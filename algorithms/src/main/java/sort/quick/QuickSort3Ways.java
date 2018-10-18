package sort.quick;

import java.util.Random;

import sort.Sort ;
import utils.ArrayUtil ;


/**
 * 快速排序优化
 * 上面快速排序的三个版本仍然存在一定的问题, 对于存在大量重复元素的数组, 
 * 排序的性能是远远低于归并排序的, 
 * 原因是因为每次进行partition实际是把数组分成小于等于v的元素和大于v的元素, 由于存在大量重复的元素
 * 所以会导致partition分割的两部分很不平衡
 * 
 * 优化方案 : 三路快排, 将数组分割成大于V,等于V, 小于V的三部分
 * @author xuxiumeng
 *
 */
public class QuickSort3Ways implements Sort {
  private static Random random = new Random();
  
    @Override
    public void sort(int [] arr) {
      quickSort3Ways(arr, 0, arr.length - 1);
    }
    
    /**
     * 对数组arr的[l, r]前闭后闭的区间进行快速排序
     * 递归方法
     * @param arr
     * @param l
     * @param r
     */
    private void quickSort3Ways(int [] arr, int l, int r){
        // 递归终止条件
        if ( r - l < 16) {
            ArrayUtil.insertSort(arr, l, r);
            return;
        }
        
        // 获取用于对比的随机元素下标
        int randomNum = random.nextInt(r - l) + l;
        ArrayUtil.swap(arr, l, randomNum);
        // 设置用于对比的元素为arr[l]
        int v = arr[l];
        
        // 设定arr[l+1...lt] < v, 初始情况下这个区间为空, 默认符合这个定义
        int lt = l; 
        // 设定arr[gt...r] > v, 初始情况下这个区间为空, 默认符合这个定义
        int gt = r + 1; 
        // arr[lt+1...i) == v, 初始情况下这个区间为空, 默认符合这个定义
        int i = l+1;
        // 在整个遍历过程中都保持arr[l+1...lt] < v, arr[gt...r] > v, arr[lt+1...i) == v
        while (i < gt) {
          if (arr[i] < v ) {
            ArrayUtil.swap(arr, i, lt + 1);
            lt++;
            i++;
           
          } else if (arr[i] > v) {
            // 这种情况下i的位置是从gt-1交换过来的元素, 仍然需要对这个元素进行判断, 所以这里不需要i++;
            ArrayUtil.swap(arr, i, gt - 1);
            gt--;
          } else {
            i++;
          }
        }
        
        ArrayUtil.swap(arr, l, lt);
        
        quickSort3Ways(arr, l, lt - 1);
        quickSort3Ways(arr, gt, r);
    }
    
}
