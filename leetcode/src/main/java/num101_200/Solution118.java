package num101_200;

import java.util.ArrayList;
import java.util.List;
// 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//在杨辉三角中，每个数是它左上方和右上方的数的和。
class Solution118 {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> list = new ArrayList<>();
      List<Integer> innerList;
      for (int i = 0; i < numRows; i++) {
        innerList = new ArrayList<>();
        if (i == 0) {
          innerList.add(1);
        } else {
          List<Integer> prevList = list.get(i - 1);
          // 下标变成行数要+1, 行数等于该行的元素个数
          for (int j = 0; j < i + 1; j++) {
            innerList.add(get(prevList, j - 1) + get(prevList, j));
          }
        }
        list.add(innerList);
      }
      return list;
    }
    
    // 辅助函数, 处理了数组下标越界的问题
    private static int get(List<Integer> list, int index){
      if (index < 0 || index >=list.size()) {
        return 0;
      } else {
        return list.get(index);
      }
    }
}