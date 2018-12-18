package num1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 */
class Solution93 {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (null == s || s.length() < 4) {
            return result;
        }
        restoreValidIp(s, 1, 0, "");
        return result;
    }

    /**
     * 在字符串查找第part部分可能的有效组合
     * @param s
     * @param part
     * @param start
     * @param temp
     */
    private void restoreValidIp(String s, int part, int start, String temp){
        int length = s.length();
        if (start >= length) {
            return;
        }
        if (part == 4) {
            if (isValid(s.substring(start))) {
                result.add(temp + s.substring(start));
            }
            return;
        } else {
            String partStr;
            for (int i = 1; i <= 3 && start + i < length ; i++) {
                partStr = s.substring(start, start + i);
                if (isValid(partStr)) {
                    restoreValidIp(s, part + 1, start + i, temp + partStr + "." );
                }
            }
        }

    }

    private boolean isValid(String partIp){
        if (partIp.length() > 3) {
            return false;
        }
        if (partIp.startsWith("0")) {
            return "0".equals(partIp);
        } else {
            return Integer.valueOf(partIp) <= 255;
        }
    }

}