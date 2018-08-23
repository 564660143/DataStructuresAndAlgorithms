package array;

public class ArrayTest {

  public static void main(String[] args) {
    Array<Integer> myArray = new Array<>(40);
    for (int i = 0; i < 10; i++) {
      myArray.addlast(i);
    }
    System.out.println(myArray);
    myArray.addFirst(-1);
    System.out.println(myArray);
    myArray.add(1, 100);
    System.out.println(myArray);
    // -1, 100, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    System.out.println(myArray.find(100));
    System.out.println(myArray.contains(100));
    System.out.println(myArray.contains(101));
    System.out.println(myArray.remove(1));
    System.out.println(myArray);
    myArray.removeElement(4);
    System.out.println(myArray);
    myArray.addlast(10086);
    myArray.addlast(10086);
    myArray.addlast(10086);
    System.out.println(myArray);
    myArray.removeAllElement(10086);
    System.out.println(myArray);
  }

}
