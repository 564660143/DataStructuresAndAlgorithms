package num101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 */
class Solution131 {
    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        findPalindrome(s, 0, 1, new ArrayList<String>());
        return result;
    }

    // 查找字符串s在[l...r)区间作为一个回文部分的所有符合条件的组合
    // 如果[l...r)区间不是回文串, 则无符合条件组合
    private void findPalindrome(String s, int l, int r, List<String> temp){

        // 遍历s的子串[l,l + 1), [l, l+2)..[l...r)
        while (r <= s.length()){
            if (isPalindrome(s, l, r)) {
                temp.add(s.substring(l, r));
                if (r == s.length()) {
                    // java是引用类型, 所以这里要拷贝一份添加到result中
                    result.add(new ArrayList<>(temp));
                    // 回溯
                    temp.remove(temp.size() - 1);
                    return;
                }
                findPalindrome(s, r, r + 1, temp);
                // 回溯
                temp.remove(temp.size() - 1);
            }
            r++;
        }


    }

    /**
     * 判断字符串[l...r)区间的字符是否符合回文串
     * 使用双指针方式判断是否为回文串
     * @param s
     * @param l
     * @param r
     * @return
     */
    private boolean isPalindrome(String s, int l, int r){
        if (l >= r || l < 0 || s == null ||  r - 1 > s.length()) {
            return false;
        }
        while (l < r) {
            if (s.charAt(l) != s.charAt(r - 1)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}