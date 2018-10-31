package num701_800;

/**
 * 717. 1比特与2比特字符
 * @author xuxiumeng
 *
 */
class Solution717 {
  // 遍历数组, 1就一次跳两位, 0就跳1位, 直到最后一个字符, 最后一个字符0开头则为true,否则false
  public boolean isOneBitCharacter(int[] bits) {
    int i = 0;
    boolean isOne = false;
    while (i < bits.length) {
      if (bits[i] == 0) {
        isOne = true;
        i++;
      } else {
        isOne = false;
        i = i + 2;
      }
    }

    return isOne;
  }
}
