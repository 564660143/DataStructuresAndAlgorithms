package num101_200;

/**
 * 125. 验证回文串
 */
class Solution125 {
    public boolean isPalindrome(String s) {
      if (null == s || "".equals(s)) {
        return true;
      }
      char[] chars = s.toLowerCase().toCharArray();
      int left = 0, right = chars.length - 1;
      // left == right的情况, 表示除了最中间的一个字符之外, 其他的满足回文串情况
      while(left<right){
        if (!isNumOrChar(chars[left])) {
          left++;
          continue;
        }
        if (!isNumOrChar(chars[right])) {
          right--;
          continue;
        }
        
         if (chars[left] == chars[right]) {
           left++;
           right--;
        } else {
          return false;
        }
      }
      
      return true;
    }
    
    private boolean isNumOrChar(char c){
      if(c >= '0' && c <= '9'){
        return true;
      }
      
      if(c >= 'a' && c <= 'z'){
        return true;
      }
      return false;
    }
}
