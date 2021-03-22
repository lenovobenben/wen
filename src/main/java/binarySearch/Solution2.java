package binarySearch;

/**
 * 33. 搜索旋转排序数组
 */
public class Solution2 {

    public int search(int[] arr, int n) {
        int lastValue = arr[arr.length - 1];// 最后一个元素的值
        // 折半查找的动态下标
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            if (arr[start] == n) {
                return start;
            }
            if (arr[end] == n) {
                return end;
            }
            int temp = (start + end) / 2; // 折半 index
            if (arr[temp] == n) {// 直接返回
                return temp;
            } else {// 改变下标
                if (arr[temp] > lastValue) {// temp 在大数组
                    if (n > arr[temp]) {// 比大数组的某元素大的，只能在temp的右边
                        start = temp + 1;
                    } else {// 比大数组的某元素小的，可能在左边，也可能在小数组里
                        if (n > lastValue) {// 在temp左边
                            end = temp - 1;
                        } else {// 在小数组里
                            start = temp + 1;
                        }
                    }
                } else {// temp 在小数组
                    if (n < arr[temp]) {// 比小数组的某元素还小的值，只能在temp左边
                        end = temp - 1;
                    } else {// 比小数组的某元素大的值，可能在右边，也可能在大数组里
                        if (n > lastValue) {// 在大数组里
                            end = temp - 1;
                        } else {// 在小数组里，右边
                            start = temp + 1;
                        }
                    }
                }
            }
        }
        return -1;// 找不到
    }

}
