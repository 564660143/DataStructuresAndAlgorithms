package queue;

import array.Array;

public class ArrayQueue<E> implements Queue<E> {
  private Array<E> arr;
  
  public ArrayQueue(int  capacity) {
    arr = new Array<E>(capacity);
  }

  public ArrayQueue() {
    this(10);
  }

  /**
   * 入队
   */
  @Override
  public void enqueue(E e) {
    arr.addlast(e);
  }

  /**
   * 出队
   */
  @Override
  public E dequeue() {
    if (arr.isEmpty()){
      throw new RuntimeException("不能对空队列执行出队操作---");
    }
    return arr.removeFirst();
  }

  /**
   * 获取队首元素
   */
  @Override
  public E getFront() {
    if (arr.isEmpty()){
      throw new RuntimeException("不能对获取空队列队首元素---");
    }
    return arr.getFirst();
  }

  @Override
  public int getSize() {
    return arr.getSize();
  }

  @Override
  public boolean isEmpty() {
    return arr.isEmpty();
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append(String.format("ArrayQueue : size = %d, capacity=%d", arr.getSize(), arr.getCapacity()));
    res.append(" front [ ");
    for (int i = 0; i < arr.getSize(); i++) {
      res.append(arr.get(i));
      if (i != arr.getSize() - 1) {
        res.append(", ");
      }
    }
    res.append(" ] end");
    return res.toString();
  }
  

}
