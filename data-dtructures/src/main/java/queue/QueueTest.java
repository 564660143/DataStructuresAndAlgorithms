package queue;

import java.util.Random;

import org.junit.Test;

public class QueueTest {
//  Queue<Integer> queue = new ArrayQueue<Integer>();
  Queue<Integer> queue = new LoopQueue<Integer>();
  
  @Test
  public void testBase(){
    for (int i = 0; i < 100; i++) {
      if (i % 3 == 1) {
        queue.dequeue();
      } else {
        queue.enqueue(i);
      }
      System.out.println(queue);
    }
  }
  
  @Test
  public void testArrayQueuePer(){
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 200000; i++) {
      queue.enqueue(new Random().nextInt(100000));
    }
    while (!queue.isEmpty()) {
      queue.dequeue();
    }
    long endTime = System.currentTimeMillis();
    System.err.println("耗时 : " + (endTime - startTime) + "毫秒");
  }
  
  @Test
  public void testLoopQueuePer(){
    queue = new LoopQueue<Integer>();
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 200000; i++) {
      queue.enqueue(new Random().nextInt(100000));
    }
    while (!queue.isEmpty()) {
      queue.dequeue();
    }
    long endTime = System.currentTimeMillis();
    System.err.println("耗时 : " + (endTime - startTime) + "毫秒");
  }
  

}
