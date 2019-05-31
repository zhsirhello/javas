package leetcode;

/**
 * 给定字符串PAYPALISHIRING，返回"PAHNAPLSIIGYIR"
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 规律是，除了第一层和最后一层，其余每层都填满。行数为nRows的时候 周期t= 2*nRows-2
 */
public class ZigzagConversion {
    public String convert(String s, int nRows) {
        if(s == null || s.length() == 0 || nRows <= 1)
            return s;

        StringBuffer[] sb = new StringBuffer[nRows];
        for(int i = 0; i < sb.length; i++)
            sb[i] = new StringBuffer();

        int len = s.length();
        int i = 0;
        while(i < len){
            for(int j = 0; j < nRows && i < len; j++)
                sb[j].append(s.charAt(i++));
            for(int j = nRows - 2; j > 0 && i < len; j--)
                sb[j].append(s.charAt(i++));
        }

        for(int j = 1; j < nRows; j++)
            sb[0].append(sb[j]);

        return sb[0].toString();
    }
}
