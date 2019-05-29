package leetcode;

/**
 * 字符串中有空格隔开，返回最后一个单词的长度
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] ss = s.split("\\s");
        if (ss.length == 0)
            return 0;

        return ss[ss.length-1].length();
    }
}
