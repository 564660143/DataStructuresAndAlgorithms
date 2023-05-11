package num1_100;

/**
 * 3.无重复字符的最长子串
 * 双指针-滑动窗口
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] freq = new char[256];
        // 设定s的[left,right]子串无重复字符
        int l = 0, r = -1;
        int max = 0;
        while (l < s.length()){
            // 如果r已经到最后了,表示最长子串已经找到了, 下面的所有子串都比这个小
            if (r == s.length() - 1){
                break;
            }

            // 如果r+1个字符的频次为0,表示这个字符还没有出现过,r可以往后移动一位, 同时将频次加1
            if (freq[s.charAt(r + 1)] == 0){
                freq[s.charAt(r + 1)]++;
                r++;
                max = Math.max(max, r - l + 1);
            // 如果r+1个字符的频次不为0,表示这个字符已经出现过了,则将l往后移动一位, 同时将频次减1
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
        }
        return max;
    }

}