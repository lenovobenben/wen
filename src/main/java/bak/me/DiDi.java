package bak.me;

import java.util.ArrayList;

/**
 * 通过位运算求一个集合的所有子集
 */
public class DiDi {

    public ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> L) {
        if (L.size() > 0) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < Math.pow(2, L.size()); i++) {// 集合子集个数=2的该集合长度的乘方
                ArrayList<Integer> subSet = new ArrayList<Integer>();
                int index = i;// 索引从0一直到2的集合长度的乘方-1
                for (int j = 0; j < L.size(); j++) {
                    // 通过逐一位移，判断索引哪一位是1，如果是，再添加此项
                    if ((index & 1) == 1) {// 位与运算，判断最后一位是否为1
                        subSet.add(L.get(j));
                    }
                    index >>= 1;// 索引右移一位
                }
                result.add(subSet); // 把子集存储起来
            }
            return result;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> L = new ArrayList<Integer>();
        L.add(1);
        L.add(2);
        L.add(3);
        System.out.println(new DiDi().getSubset(L));
    }

}
