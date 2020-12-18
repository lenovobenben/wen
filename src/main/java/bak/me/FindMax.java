package bak.me;

/**
 * 美团面试题
 * 先递增，后递减 的数组 ，求出最大值的 index
 * 递增/递减 中无重复数字
 */
public class FindMax {
    public int findMax(int[] arr) {
        int start = 0;
        int end = arr.length;

        while (true) {
            if (start == end) {
                return start;
            }
            int temp = (start + end) / 2;
            if (arr[temp] > arr[temp - 1] && arr[temp] > arr[temp + 1]) {
                return temp;
            }
            if (arr[temp] > arr[temp - 1]) {// 递增
                start = temp;
            } else if (arr[temp] < arr[temp - 1]) {// 递减
                end = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindMax().findMax(new int[]{1, 2, 3, 4, 5, 6, 7, 5, 4, 3, 2, 1}));
    }
}
