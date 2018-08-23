package array;

/**
 * 动态数组
 * @author xuxiumeng
 * @param <E>
 */
public class Array<E> {
  private int size;
  private E[] data;

  public Array() {
    this(10);
  }

  @SuppressWarnings("unchecked")
  public Array(int capacity) {
    data = (E[])new Object[capacity];
    size = 0;
  }

  /**
   *  获取数组中元素个数
   * @return
   */
  public int getSize() {
    return size;
  }

  /**
   *  获取数组容量
   * @return
   */
  public int getCapacity() {
    return data.length;
  }

  /**
   *  判断数组是否为空
   * @return 为空返回true,不为空返回false
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   *  添加元素到第一个位置
   * @param e
   */
  public void addFirst(E e) {
    this.add(0, e);
  }

  /**
   *  添加元素到最后一个位置
   * @param e
   */
  public void addlast(E e) {
    this.add(size, e);
  }

  /**
   *  向指定位置index处添加元素
   * @param index
   * @param e
   */
  public void add(int index, E e) {
    if (size == data.length) {
      resize(2 * data.length);
    }

    if (index < 0 || index > size) {
      throw new IllegalArgumentException("add fail, index must between 0 and size");
    }
    for (int i = size - 1; i >= index; i--) {
      data[i + 1] = data[i];
    }
    data[index] = e;
    size++;
  }

  /**
   *  获取第一个的元素
   * @return
   */
  public E getFirst() {
    return data[0];
  }
  
  /**
   *  获取最后一个的元素
   * @return
   */
  public E getlast() {
    return get(size - 1);
  }
  
  /**
   *  获取index索引位置的元素
   * @param index
   * @return
   */
  public E get(int index) {
    checkIndex(index, "Get fail, index must between 0 and size");
    return data[index];
  }

  /**
   *  更新index索引位置元素
   * @param index
   * @param e
   */
  public void set(int index, E e) {
    checkIndex(index, "Get fail, index must between 0 and size");
    data[index] = e;
  }

  /**
   *  查找元素e,返回下标index,查找不到返回-1
   * @param e
   * @return
   */
  public int find(E e) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(e)) {
        return i;
      }
    }
    return -1;
  }

  /**
   *  判断是否包含某个元素
   * @param e
   * @return
   */
  public boolean contains(E e) {
    return !(find(e) == -1);
  }

  /**
   *  删除指定索引index位置的元素
   * @param index
   * @return
   */
  public E remove(int index) {
    E ret = data[index];
    for (int i = index; i < size; i++) {
      data[i] = data[i + 1];
    }
    size--;
    // 释放data[size]对象引用,帮助GC
    data[size] = null;
    if (size == data.length / 4 && data.length / 2 != 0) {
      resize(data.length / 2);
    }
    return ret;
  }

  /**
   *  删除数组第一个元素
   * @return
   */
  public E removeFirst() {
    return remove(0);
  }

  /**
   *  删除数组最后一个元素
   * @return
   */
  public E removeLast() {
    return remove(size - 1);
  }

  /**
   *  删除数组中第一个等于e的元素
   * @param e
   */
  public void removeElement(E e) {
    int index = find(e);
    if (index != -1) {
      remove(index);
    }
  }
  
  /**
   * 删除数组中所有等于e的元素
   * @param e
   */
  public void removeAllElement(E e) {
    int index = -1;
    while ((index = find(e)) != -1) {
      remove(index);
    }
  }

  private void checkIndex(int index, String msg) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException(msg);
    }
  }

  // 数组扩容/或者缩容
  @SuppressWarnings("unchecked")
  private void resize(int newCapacity){
    E[] newData = (E[]) new Object[newCapacity];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }
  
  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append(String.format("Array : size = %d, capacity=%d", size, data.length));
    res.append("[");
    for (int i = 0; i < size; i++) {
      res.append(data[i]);
      if (i != size - 1) {
        res.append(", ");
      }
    }
    res.append("]");
    return res.toString();
  }

}
