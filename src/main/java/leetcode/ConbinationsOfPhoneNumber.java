package leetcode;

import java.util.ArrayList;

/**
 * 其实就是字符串数组中字符的组合，每个字符串出一个字符。
 * 回溯法
 */
public class ConbinationsOfPhoneNumber {

    ArrayList<String> res=new ArrayList<String>();
    public ArrayList<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            res.add("");
            return res;

        }

        String[] mapping={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        letterCombinations(digits,0,"",mapping);

        return res;
    }


    private void letterCombinations(String digits, int i, String string,String[] mapping) {
        if(i>=digits.length()){
            res.add(string);
            return;
        }
        String strs=mapping[Character.getNumericValue(digits.charAt(i))];

        for(char c:strs.toCharArray()){
            letterCombinations(digits,i+1,string+c,mapping);
        }

    }
}
