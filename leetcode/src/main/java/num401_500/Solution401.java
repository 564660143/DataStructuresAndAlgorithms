package num401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. 二进制手表
 */
class Solution401 {
    private int[] hours = new int[]{1, 2, 4, 8};
    private int[] minutes = new int[]{1, 2, 4, 8, 16, 32};
    List<String> result = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        List<Integer> tempHours;
        for (int h = 0, m = num - h; h < 4 && h <= num; ) {
            // 表示分钟的灯最多亮5个
            if (m < 0 || m > 5){
                h++;
                m--;
                continue;
            }

            tempHours = new ArrayList<>();
            // 获取表示小时的灯h个灯亮时能够表示的所有小时数
            getHour(h, 0, 0, tempHours);
            for (int i = 0; i < tempHours.size(); i++) {
                // 表示分钟数的灯有m个灯亮时能够表示的多有分钟数, 结合小时数组成时间
                getMinute(m, 0, 0, tempHours.get(i));
            }
            h++;
            m--;
        }

        return result;
    }

    // 获取hourNum个灯亮时能表示的全部小时说
    private void getHour(int hourNum, int index, int sum, List<Integer> tempHours){
        if (hourNum == 0) {
            if (sum < 12) {
                tempHours.add(sum);
            }
            return;
        }

        for (int i = index; i < 4; i++) {
            sum += hours[i];
            getHour(hourNum - 1, i + 1, sum, tempHours);
            // 回溯
            sum -= hours[i];
        }
    }

    // minuteNum个灯亮时能够表示的全部分钟数, 结合小时说组成时间
    private void getMinute(int minuteNum, int index, int sum, int hour){
        if (minuteNum == 0) {
            if (sum < 60) {
                result.add(hour + formatMinute(sum));
            }
            return;
        }

        for (int i = index; i < 6; i++) {
            sum += minutes[i];
            getMinute(minuteNum - 1, i + 1, sum, hour);
            // 回溯
            sum -= minutes[i];
        }
    }

    private String formatMinute(int minute) {
        if (minute == 0) {
            return ":00";
        }
        if (minute < 10) {
            return ":0" + minute;
        }
        return ":" + minute;
    }

}