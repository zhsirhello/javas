package leetcode;

import java.util.ArrayList;

/**
 * 输入n，表示括号对数。求括号所有可能的排列
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
    ArrayList<String> r = new ArrayList<String>();
    public ArrayList<String> generateParenthesis(int n) {
        //保证左边‘（’的数量始终大于等于右边的‘）’数量，可以考虑回溯法
        ArrayList<String> s = new ArrayList<String>();
        gp("",0,0,n);
        return r;
    }
    private void gp(String s,int left,int right,int n){
        if(right == n){
            r.add(s);
        }
        if(left < n){
            gp(s+"(",left+1,right,n);
        }
        // 递归过程中 左括号x的个数必须大于等于右括号个数
        if(left > right){
            gp(s+")",left,right+1,n);
        }
    }
}
