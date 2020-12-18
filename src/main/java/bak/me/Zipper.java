package bak.me;

/**
 * 现给定一个string iniString字符串(长度小于等于10000)，请按连续重复字母压缩的方式将该字符串压缩，返回结果为string
 * 比如，字符串“aabbcccccaaa”经压缩会变成“a2b2c5a3”，若压缩后的字符串没有变短，则返回原先的字符串。注意保证串内字符均由大小写英文字母组成。
 */
public class Zipper {
    public static void main(String[] args) {
        System.out.println(new Zipper().zip("aabbcccccaaa"));
    }

    public String zip(String str) {

        StringBuilder stringBuilder = new StringBuilder();

        char lastChar = 0;
        int lastCharNum = 0;

        for (int i = 0; i < str.length(); i++) {

            // 第一个特殊处理
            if (i == 0) {
                lastChar = str.charAt(0);
                lastCharNum = 1;
                continue;
            }

            char cur = str.charAt(i); // 当前的 char
            if (lastChar == cur) {// 和上一个相同
                lastCharNum++;
            } else {// 新的 char
                stringBuilder.append(lastChar).append(lastCharNum); // 上一个写入 stringBuilder

                // 重新赋值
                lastChar = cur;
                lastCharNum = 1;
            }

            // 最后一个特殊处理
            if (i == str.length() - 1) {
                stringBuilder.append(lastChar).append(lastCharNum);
            }
        }

        if (stringBuilder.length() > str.length()) {
            return str;
        } else {
            return stringBuilder.toString();
        }
    }
}
