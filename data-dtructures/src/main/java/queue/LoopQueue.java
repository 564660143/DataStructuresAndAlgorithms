package queue;

/**
 * 循环队列
 * 以数组表示循环队列
 * arr : 用于存储队列元素
 * front : 用于标识队首元素位于数组arr中的索引位置
 * tail : 队尾元素位于arr数组中的索引位置
 * 
 * 设计 : 只有front == tail时标识队列为空, 因此队列中有个元素空间被有意识的浪费了
 * tail % getCapacity = front -1 时标识队列已满
 * @author 七夜雪
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {
  private E[] data;
  private int front;
  private int  tail;
  private int  size;
  
  
  public LoopQueue() {
    this(10);
  }

  @SuppressWarnings("unchecked")
  public LoopQueue(int capacity) {
    // 因数组中有个元素被有意识的浪费了,所以new的数组长度为capacity + 1
    data = (E[]) new Object[capacity + 1];
    front = 0;
    tail = 0;
    size = 0;
  }
  
  @Override
  public void enqueue(E e) {
//    System.out.println(String.format("front = %d, tail =%d   size = %d, capacity=%d", front, tail, size, getCapacity()));
    // 判断队列是否已满, 队列已满的情况下进行扩容
    if ((tail + 1) % data.length == front) {
      resize(getCapacity() * 2);
    }
    data[tail] = e;
    tail = (tail +1) % data.length;
    size ++;
  }

  @Override
  public E dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("不能对空队列执行出队操作---");
    }

    E ret = data[front];
    // 释放对象引用, gc可以回收已出队元素
    data[front] = null;
    front = (front + 1) % data.length;
    size --;
    // 如果队列已经小于capacity/4了,就对队列进行缩容, 但不能将队列缩容到0
    if (size == getCapacity() / 4 && getCapacity() / 2 != 0 ) {
      resize(getCapacity() / 2);
    }
    return ret;
  }

  @Override
  public E getFront() {
    return data[front];
  }

  @Override
  public int getSize() {
    return size;
  }

  
  @Override
  public boolean isEmpty() {
    return front == tail;
  }
  
  /**
   * 获取到当前队列容量, 当tail==front时,队列为空
   * @return
   */
  public int getCapacity(){
    return data.length -1;
  }
  
  /**
   * 数组扩容或者缩容
   */
  @SuppressWarnings("unchecked")
  private void resize(int newCapacity){
    E[] newArr = (E[]) new Object[newCapacity + 1];
    for (int i = 0; i < size; i++) {
      newArr[i] = data[(i + front) % data.length];
    }
    data = newArr;
    front = 0;
    tail = size;
  }

//  @Override
//  public String toString() {
//    StringBuilder res = new StringBuilder();
//    res.append(String.format("ArrayQueue : size = %d, capacity=%d", size, getCapacity()));
//    res.append(" front [ ");
//    for (int i = front; i != tail; i = (i + 1) % arr.length) {
//      res.append(arr[i]);
//      if((i + 1) % arr.length != tail) {
//        res.append(", ");
//      }
//    }
//    res.append(" ] end");
//    return res.toString();
//  }
  
  @Override
  public String toString(){

      StringBuilder res = new StringBuilder();
      res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
      res.append("front [");
      for(int i = front ; i != tail ; i = (i + 1) % data.length){
          res.append(data[i]);
          if((i + 1) % data.length != tail)
              res.append(", ");
      }
      res.append("] tail");
      return res.toString();
  }
  

}
