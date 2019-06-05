package leetcode;

/**
 * 数数字
 * 总结规律，然后强行干~！
 * 1, 11, 21, 1211, 111221、312211....
 */
public class CoutAndSay {
    public String countAndSay(int n) {
        int i=1;
        String result = "1";
        while(i<n){
            result = countOnce(result);
            i++;
        }
        return result;
    }
    public String countOnce(String res){
        char c = res.charAt(0);
        int num=1;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<res.length();i++){
            if(res.charAt(i)==c){
                num++;
                continue;
            }
            sb.append(String.valueOf(num)+c);
            c=res.charAt(i);
            num=1;
        }
        sb.append(String.valueOf(num)+c);
        return sb.toString();
    }
}
