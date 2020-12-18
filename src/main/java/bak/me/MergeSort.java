package bak.me;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 */
public class MergeSort {

    public void mergeSort(int[] arr) {
        // 拷贝数组
        int[] copy = new int[arr.length];
        System.arraycopy(arr,0,copy,0,arr.length);

        // 递归
        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));


        // 非递归
        sort(copy);

        System.out.println(Arrays.toString(copy));
    }

    /**
     * 归并排序（递归实现）
     * 时间复杂度 O(nlogn)
     * 空间复杂度O(n + logn)
     *
     * @param arr
     * @param left
     * @param right
     */
    private void sort(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;
        // 左边
        sort(arr, left, mid);
        // 右边
        sort(arr, mid + 1, right);
        // 合并并排序
        merge(arr, left, mid, right);
    }

    /**
     * 归并排序（非递归实现）
     * 时间复杂度O(nlogn)
     * 空间复杂度O(n)
     *
     * @param arr
     */
    private void sort(int[] arr) {
        // 从 1开始分割，与递归不同的是，递归由数组长度一分为二最后到1，
        // 而非递归则是从1开始扩大二倍直到数组长度
        int len = 1;

        while (arr.length > len) {

            // 完全二叉树一层内的遍历
            for (int i = 0; i + len <= arr.length - 1; i += len * 2) {
                int left = i;
                int mid = i + len - 1;
                int right = i + len * 2 - 1;

                // 防止超出数组长度
                if (right > arr.length - 1)
                    right = arr.length - 1;

                // 合并排序相同
                merge(arr, left, mid, right);
            }

            // 下一层
            len *= 2;
        }
    }

    /**
     * 合并并排序
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        // 注意： 此处并没有全部放入temp中，当一边达到mid或right时就是退出循环
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        // 如果左边或右边有剩余，则继续放入，只可能一边有剩余
        while (i <= mid)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        // 排好序的临时数组重新放入原数组
        for (int m = 0; m < temp.length; m++) {
            arr[m + left] = temp[m];
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(50);
        }

        System.out.println(Arrays.toString(arr));

        new MergeSort().mergeSort(arr);

    }

}