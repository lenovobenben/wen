package bak.me;

/**
 * 给定一个正整数n，请返回0到n(包括n)的数字中 多少个数内包含2。
 *
 * 测试样例：
 * 10
 * 返回：1
 */
public class CountNumberOf2s {
    public static void main(String[] args) {
        CountNumberOf2s countNumberOf2s = new CountNumberOf2s();
        // 测试代码
        for (int i = 0; i < 56322; i++) {
            int a = countNumberOf2s.countNumberOf2s(i);
            int b = countNumberOf2s.countNumberOf2s_(i);
            if (a!=b) {
                System.out.println(a+ "  " + b);
            }
        }
    }

    public  int countNumberOf2s (int n){// 假设 n = 56321

        // 先来计算 9999 内含有2的个数
        String str = n + "";
        int num = str.length() - 1;// 9的个数，这里为 4

        if (num == 0) {// 特殊处理
            if (n<2) {
                return 0;
            } else {
                return 1;
            }
        }

        // 含有2的数的个数： 10的num次方 - 9的num次方。注意从0到9999有10000个数，而不是 9999 个
        int exp10 = 1;
        int exp9 = 1;
        for (int i = 0; i < num; i++) {
            exp10 = 10 * exp10;
            exp9 = 9 * exp9;
        }

        int nTemp = exp10 - exp9;// 4 个 9 内 含有2的个数

        int ret = 0;
        int topHighValue = Integer.parseInt(str.charAt(0)+"");// 最高位的值
        // 分情况讨论
        if (topHighValue < 2) {// 最高位小于2，则确定为1。相当于 9999 内的值 + 1XXXX 后面的含有2的个数
            ret = nTemp + countNumberOf2s(Integer.parseInt(str.substring(1)));// 递归调用，这里调用 countNumberOf2s (6321)
        } else if (topHighValue == 2) {// 最高位正好是2
            ret = nTemp * 2 + Integer.parseInt(str.substring(1)) + 1;// 相当于最高位 0 1 各自有 9999 的个数 + 最高位 2 所有<=n的数字都算在内，注意要加1
        } else {// 大于2，比如5，相当于最高位 0 1 3 4 各自拥有 9999的个数 + 最高位 2 拥有所有个数 + 最高位 5XXXX 拥有的个数
            ret = nTemp * (topHighValue - 1) + exp10 + countNumberOf2s(Integer.parseInt(str.substring(1)));// 需要递归
        }

        return ret;
    }


    /**
     * 笨办法，仅用于验证
     */
    public  int countNumberOf2s_ (int n){
        int ret = 0;
        for (int i = 0; i < n+1; i++) {
            String temp = i + "";
            if (temp.contains("2")) {
                ret++;
            }
        }

        return ret;
    }
}
