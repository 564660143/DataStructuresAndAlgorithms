package queue;

public interface Queue<E> {
  /**
   * 入队
   * @param e
   */
  void enqueue(E e);
  
  /**
   * 出队
   * @return
   */
  E dequeue();
  
  /**
   * 获取队首元素
   * @return
   */
  E getFront();
  
  /**
   * 获取队列长度
   */
  int getSize();
  
  /**
   * 获取队列是否为空
   * @return
   */
  boolean isEmpty();
  
  
}
