package offer;

/**
 * 翻转字符串顺序列
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 *
 * 注意：判断空字符串的方式。trim
 */
public class Solution37 {
    public String ReverseSentence(String str) {
        //trim()方法去掉了字符串头尾小于等于“ ”的所有字符
        if(str.trim().equals("")){
            return str;
        }
        String[] s = str.split(" ");
        String temp;
        for(int i=0;i<s.length/2;i++){
            temp=s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=temp;
        }
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<s.length;i++){
            buffer.append(s[i]);
            buffer.append(" ");
        }
        buffer.deleteCharAt(buffer.length()-1);
        return buffer.toString();
    }
}
