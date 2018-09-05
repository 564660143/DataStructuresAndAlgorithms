package stack;

import stack.ArrayStack;
import stack.Stack;

public class StackTest {

  public static void main(String[] args) {
    Stack<Integer> stack = new ArrayStack<>();
    for (int i = 0; i < 10; i++) {
        stack.push(i);
    }
    System.out.println(stack);
    stack.pop(); 
    for (int i = 0; i < 20; i++) {
      if (i % 3 == 0) {
        stack.pop(); 
      } else {
        stack.push(i);
      }
      System.out.println(stack);
    }
    
    System.out.println(stack.peek());
  }

}
