package num201_300;

/**
 * 215. 数组中的第K个最大元素
 */
class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, k);
    }
    
    // 在nums数组[l...r]区间查找第k个最大元素
    // 使用三路快排的partition操作, 设定标定点为v, 等于v的部分就是这部分元素在数组中应该待的位置
    // 判断k是否在等于v的部分,如果在的话, 就直接返回nums[k]即可
    // 如果k在小于v的部分, 就在小于v的部分继,否则就在大于v的部分继续寻找
    private int partition(int[] nums, int l, int r, int k){
        int mid = l + (r - l) / 2;
        swap(nums, l, mid);
        int v = nums[l];
        int left = l - 1; // 设定nums[l...left]区间的元素都大于v
        int i = l; // 设定nums[left+1...i)区间的元素都等于v, i表示当前要考察的元素
        int right = r + 1; // 设定[right...r]区间的元素都小于v
        while(i < right){
            if(nums[i] > v){
                swap(nums, i, left + 1);
                left++;
                i++;
            } else if (nums[i] == v){
                i++;
            } else { // nums[i] < v
                swap(nums, i, right - 1);
                right--;
            }
        }
        
        if(k -1 <= left){
            return partition(nums, l, left, k);
        } else if (k - 1 >=right) {
            return partition(nums, right, r, k);
        } else { // left < k -1 < right , 表示第k个最大元素就在[left+1, right -1]这个区间中, 第k个最大元素已经处于它应该在的位置了,直接返回nums[k]即可
            // 数组下标从0开始,
            return nums[k - 1];
        }
        
        
    }
    
    private void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}