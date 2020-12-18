package bak.me;

/**
 * 老虎金融 面试题
 * <p>
 * <p>
 * <p>
 * 给定数组（先不讨论数组元素重复的情况）：
 * {7,8,9,     1,2,3,4,6}
 * 左右两边都是有序数组，假如把左边的数组移动到右边后，则整体是一个有序数组
 * <p>
 * 形如此类的数组中，查找某个元素是否存在，如果存在，打印下标；不存在，返回 -1
 * <p>
 * 要求时间复杂度
 */
public class Tiger {

    public static void main(String[] args) {
        int find = new Tiger().process(new int[]{7, 8, 9, 0, 1, 2, 3, 4, 6}, 6);
        System.out.println(find);
    }


    public int process(int[] arr, int n) {

        int lastValue = arr[arr.length - 1];// 最后一个元素的值

        if (arr[0] == n) {
            return 0;
        }

        if (lastValue == n) {
            return arr.length - 1;
        }

        // 不是首位/末位
        // 折半查找的动态下标
        int startIndex = 0;
        int endIndex = arr.length - 1;


        while (true) {

            if (arr[startIndex] == n) {
                return startIndex;
            }

            if (arr[endIndex] == n) {
                return endIndex;
            }

            if (endIndex - startIndex <= 1) {// 不存在
                return -1;
            }

            int temp = (startIndex + endIndex) / 2; // 折半 index

            if (arr[temp] == n) {// 直接返回
                return temp;
            } else {// 改变下标

                // 先判断中间的值，是属于 大数组（左），还是小数组（右）
                if (arr[temp] > lastValue) {// 大数组
                    if (n > arr[temp]) {// 比大数组的某元素大的，只能在temp的右边
                        startIndex = temp;
                    } else {// 比大数组的某元素小的，可能在左边，也可能在小数组里
                        if (n > lastValue) {// 在temp左边
                            endIndex = temp;
                        } else {// 在小数组里
                            startIndex = temp;
                        }
                    }
                } else {// 小数组
                    if (n < arr[temp]) {// 比小数组的某元素还小的值，只能在temp左边
                        endIndex = temp;
                    } else {// 比小数组的某元素大的值，可能在右边，也可能在大数组里
                        if (n > lastValue) {// 在大数组里
                            endIndex = temp;
                        } else {// 在小数组里
                            startIndex = temp;
                        }
                    }
                }
            }

        }
    }

}
