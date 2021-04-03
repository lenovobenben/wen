package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 179. 最大数
 * <p>
 * 输入一个正整数数组，将它们连接起来排成一个数，输出能排出的所有数字中最大的一个
 * 比如 75,9,7,76,54,79,112,776 ，应该输出 9,79,7,776,76,75,54,112
 */
class Solution {

    public String largestNumber(int[] arr) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(String.valueOf(arr[i]));
        }

        // 核心代码
        Comparator<String> comparator = (a, b) -> (b + a).compareTo(a + b);
        list.sort(comparator);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
        }

        String result = stringBuilder.toString();
        //特殊情况 若干个零
        if (result.charAt(0) == '0') {
            result = "0";
        }
        return result;
    }

}