package bak.me;

import java.security.SecureRandom;
import java.util.HashMap;

/**
 * 从 1 到 m （包括1 m）,随机出 n 个不同的数
 */
public class TEST {

    public int[] randomNum(int m, int n) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        SecureRandom r = new SecureRandom();

        for (int i = 0; i < n; i++) {
            int ran = r.nextInt(m - i) + i;
            // 交换 ran i
            int temp = arr[i];
            arr[i] = arr[ran];
            arr[ran] = temp;
        }

        int[] ret = new int[n];
        System.arraycopy(arr, 0, ret, 0, n);
        return ret;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        map.put(7, 0);
        map.put(8, 0);
        map.put(9, 0);
        for (int i = 0; i < 100000; i++) {
            int[] a = new TEST().randomNum(9, 4);
            for (int j = 0; j < a.length; j++) {
                map.put(a[j], map.get(a[j]) + 1);
            }
        }

        System.out.println(map);
    }
}
