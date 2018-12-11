package num301_400;

import helper.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 */
public class NestedIterator implements Iterator<Integer> {

    private List<Integer> data;
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        data = new ArrayList<>();
        nestedIntegerToInteger(nestedList);
    }

    private void nestedIntegerToInteger(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                data.add(nestedInteger.getInteger());
            } else {
                nestedIntegerToInteger(nestedInteger.getList());
            }
        }

    }

    @Override
    public Integer next() {
        return data.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < data.size();
    }
}