package num1_100;

/**
 * 88.合并两个有序数组
 * 从后往前进行merge
 * @author 七夜雪
 *
 */
class Solution88 {
    // 从后往前进行merge, 避免覆盖元素
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n -1;
        while(m > 0 || n > 0){
           // n == 0表示数组2已经merge完成, num1不需要再进行merge了
            if(n == 0){
               return;
           } else if(m == 0){
                nums1[index] = nums2[n - 1];
                n--;
            } else if(nums1[m-1] > nums2[n-1]){
                nums1[index] = nums1[m - 1];
                m--;
            } else {
                nums1[index] = nums2[n - 1];
                n--;
            }
            index--;
        }
        
    }
}