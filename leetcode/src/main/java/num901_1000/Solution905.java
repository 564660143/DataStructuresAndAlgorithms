package num901_1000;

/**
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 * @author xuxiumeng
 *
 */
public class Solution905 {
    
    /**
     *  交换两个元素位置, 辅助代码
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * 返回一个数组是否是偶数, 辅助函数
     * @return
     */
    private static boolean isEven(int num){
      return num % 2 == 0;
    }
    
    /****************解题思路*********************/
    /*
     * 由于是将数组分厂奇数和偶数的两部分, 这样就可以参考使用对数组使用快速排序的思想
     * 对整个数组进行一次partition操作, 得到的就是目标数组
     */
    
    public int[] sortArrayByParity(int[] A) {
      int l = 0; // 设定A[0~l-1]左闭右闭区间都是偶数
      int i = 0; // 设定A[l~i)左闭右开区间都是奇数
      for (i = 0; i < A.length; i++) {
        if (isEven(A[i])) {
          swap(A, i, l);
          l++;
        }
      }
      return A;
    }
}