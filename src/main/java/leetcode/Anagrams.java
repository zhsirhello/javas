package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个字符串数组，返回其anagram的字符串
 *
 * 链接：https://www.nowcoder.com/questionTerminal/e84e273b31e74427b2a977cbfe60eaf4
 * 来源：牛客网
 *
 * 首先简单介绍一下Anagram（回文构词法）。Anagrams是指由颠倒字母顺序组成的单词，“tea”会变成“eat”。
 *
 * 回文构词法有一个特点：单词里的字母的种类和数目没有改变，只是改变了字母的排列顺序。
 *
 * For example:
 *
 * Input:  ["tea","and","ate","eat","den"]
 *
 * Output:   ["tea","ate","eat"]
 */
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        if(strs == null && strs.length == 0){
            return new ArrayList<>();
        }
        ArrayList<String> li = new ArrayList<>();
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ss = s.toCharArray();
            Arrays.sort(ss);
            String a = String.valueOf(ss);
            if(!map.containsKey(a)){
                map.put(a,new ArrayList<>());
            }
            map.get(a).add(s);
        }
        for (String s:map.keySet()) {
            ArrayList<String> list = map.get(s);
            if(list.size() > 1) li.addAll(list);
        }
        return li;
    }
}
