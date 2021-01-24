package str;

/**
 * 现给定一个string iniString字符串(长度小于等于10000)，请按连续重复字母压缩的方式将该字符串压缩，返回结果为string
 * 比如，字符串“aabbcccccaaa”经压缩会变成“a2b2c5a3”，若压缩后的字符串没有变短，则返回原先的字符串。注意保证串内字符均由大小写英文字母组成。
 */
public class Zipper {
    public String zipString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char lastChar = 0;
        int lastCharNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i==0) {
                lastChar = str.charAt(0);
                lastCharNum = 1;
                continue;
            }

            char cur = str.charAt(i);
            if (lastChar == cur) {
                lastCharNum++;
            } else {
                stringBuilder.append(lastChar).append(lastCharNum);// 写上一个
                lastChar = cur;
                lastCharNum = 1;
            }

            if (i==str.length()-1) {
                stringBuilder.append(lastChar).append(lastCharNum);// 当前的
            }
        }
        return stringBuilder.length() > str.length()?str:stringBuilder.toString();
    }
}
