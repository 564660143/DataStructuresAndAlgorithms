package stack;

import array.Array;
/**
 * 基于动态数组实现的栈
 * @author 七夜雪
 *
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

  private Array<E> arr;


  public ArrayStack() {
    this(10);
  }

  public ArrayStack(int capacity) {
    this.arr = new Array<E>(capacity);
  }

  /**
   * 入栈
   * 
   * @param e
   */
  @Override
  public void push(E e) {
    arr.addlast(e);
  }

  /**
   * 出栈
   * 
   * @return
   */
  @Override
  public E pop() {
    if (isEmpty()) {
      throw new IllegalArgumentException("不能对空队列执行pop操作--");
    }
    return arr.removeLast();
  }

  /**
   * 查看栈顶元素
   * 
   * @return
   */
  @Override
  public E peek() {
    return arr.getlast();
  }

  /**
   * 查看栈中元素个数
   * 
   * @return
   */
  @Override
  public int getSize() {
    return arr.getSize();
  }

  /**
   * 判断栈是否为空
   * 
   * @return
   */
  @Override
  public boolean isEmpty() {
    return arr.isEmpty();
  }

  /**
   * 获取栈当前容量
   * 
   * @return
   */
  public int getCapacity() {
    return arr.getCapacity();
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append(String.format("ArrayStack : size = %d, capacity=%d", arr.getSize(), arr.getCapacity()));
    res.append("[");
    for (int i = 0; i < arr.getSize(); i++) {
      res.append(arr.get(i));
      if (i != arr.getSize() - 1) {
        res.append(", ");
      }
    }
    res.append("] top");
    return res.toString();
  }


}
