package num101_200 ;

import java.util.Arrays ;
import java.util.List ;

/**
 * 119. 杨辉三角 II
 * @author 七夜雪
 *
 */
class Solution119 {
	/**
	 * 按数组展示每一行如下所示:
	 * 1,0,0,0,0
	 * 1,1,0,0,0
	 * 1,2,1,0,0
	 * 1,3,3,1,0
	 * 1,4,6,4,1
	 * @param rowIndex
	 * @return
	 */
    public List<Integer> getRow(int rowIndex) {
        Integer[] rows = new Integer[rowIndex + 1];
        rows[0] = 1;
        if(rowIndex > 0){
            rows[1] = 1;
        }

        for(int i = 2;i <= rowIndex; i++){
            for(int j = i - 1;j > 0;j--){
               rows[j] = rows[j] + rows[j - 1];
            }
            rows[i] = 1;
            
        }
        return Arrays.asList(rows);
    }
}
