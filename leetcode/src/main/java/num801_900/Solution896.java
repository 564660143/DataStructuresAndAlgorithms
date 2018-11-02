package num801_900;

/**
 * 896. 单调数列
 * @author xuxiumeng
 *
 */
class Solution896 {

  private boolean isIncrease(int[] A) {
    for (int i = 1; i < A.length; i++) {
      if (A[i - 1] > A[i]) {
        return false;
      }
    }
    return true;
  }

  private boolean isDecrease(int[] A) {
    for (int i = 1; i < A.length; i++) {
      if (A[i - 1] < A[i]) {
        return false;
      }
    }
    return true;
  }

  public boolean isMonotonic(int[] A) {
    return isDecrease(A) || isIncrease(A);
  }
}
