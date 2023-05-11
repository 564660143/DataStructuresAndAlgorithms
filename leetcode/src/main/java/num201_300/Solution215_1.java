package num201_300 ;

import java.util.ArrayList ;

/**
 * 215.数组中的第K个最大元素
 * 使用最大堆实现
 * @author 七夜雪
 *
 */
class Solution215_1 {
    public int findKthLargest(int[] nums, int k) {
    	MaxHeap maxheap = new MaxHeap(nums);
        for(int i = 0; i < k - 1; i++){
            maxheap.extractMax();
        }
        
        return maxheap.extractMax();
    }
}


class MaxHeap {
    private ArrayList<Integer> data = new ArrayList<>();
     /**
	 * Heapify方式将集合中的元素添加到最大堆中
	 * @param collection
	 */
	public MaxHeap(int[] nums){
		for(int i = 0; i < nums.length; i++){
            data.add(nums[i]);
        }
        if(nums.length > 1){
            for(int i = parent(data.size() -1); i >= 0; i--){
			siftDown(i);
		}
        }
		
	}
    
    	/**
	 * 节点下沉
	 * @param index
	 */
	private void siftDown(int index){
		// 不是根节点, 且当前节点小于父节点时, 和父节点交换位置
		while (leftChild(index) < data.size()) {
			// 用于和index节点进行比较的节点, 先默认为左孩子节点
			int swapIndex = leftChild(index);
			/*
			 * swapIndex + 1 < data.size表示右孩子也不为空
			 * 右孩子节点值大于左孩子时, 使用右子树与当前节点进行比较
			 */
			if (swapIndex + 1 < data.size() && data.get(swapIndex + 1).compareTo(data.get(swapIndex)) > 0) {
				// 右孩子下标进行替换, 这里也可以直接写成swapIndex ++;
				swapIndex = rightChild(index);
			}
			
			if (data.get(swapIndex).compareTo(data.get(index)) > 0) {
				swap(index, swapIndex);
				index = swapIndex;
			} else {
				return;
			}
			
		}
	}
    
    /**
	 * 返回下标为index的节点的左孩子节点
	 * @param index
	 * @return
	 */
	private int leftChild(int index){
		return 2 * index +1;
	}
    
    /**
	 * 返回下标为index的节点的右孩子节点
	 * @param index
	 * @return
	 */
	private int rightChild(int index){
		return 2 * index +2;
	}
    
    /**
	 * 返回下标为index的节点的父节点下标值
	 * @param index
	 * @return
	 */
	private int parent(int index){
		if (index == 0) {
			throw new IllegalArgumentException("下标为0的节点不存在父节点");
		}
		return (index - 1) / 2; 
	}
    
    /**
	 * 查询最大堆中的最大元素
	 * @return
	 */
	public Integer findMax(){
		if (data.isEmpty()) {
			throw new IllegalArgumentException("当前堆为空, 无最大值");
		}
		return data.get(0);
	}

	/**
	 * 取出最大堆的元素
	 * @return
	 */
	public Integer extractMax(){
		// 获取最大值
		Integer ret = findMax();
		// 将最大值和最后一个叶子节点交换位置, 即用最后一个叶子节点替换了根节点
		swap(0, data.size() -1);
		// 删除最后一个叶子节点, 即删除了最大值
		data.remove(data.size() - 1);
		// 现在的根节点下沉
		siftDown(0);
		return ret;
	}
    
    /**
	 * 对data中的元素交换位置
	 * @param first
	 * @param second
	 */
	private void swap(int first, int second){
		Integer temp = data.get(first);
		data.set(first, data.get(second));
		data.set(second, temp);
	}
    
}

