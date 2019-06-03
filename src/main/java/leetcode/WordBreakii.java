package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * 同字典中找字符串的组合，返回所有可能的组合。
 * 动态规划加dfs(深度优先搜索算法)
 * 注意：若是new Arraylist了，但从来没有添加过元素，则for(s:arraylist){循环体}中循环体不会调用到。即不会进入到循环体
 */
public class WordBreakii {
    public ArrayList<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, ArrayList<String>>());
    }

    private ArrayList<String> DFS(String s, Set<String> wordDict, HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() == 0){
            res.add("");
            return res;
        }
        for (String subStr : wordDict) {
            if (s.startsWith(subStr)) {
                for (String str : DFS(s.substring(subStr.length()), wordDict, map)) {
                    res.add(subStr + (str == "" ? "" : " ")+ str);
                }
            }
        }
        map.put(s, res);
        return res;

    }
}
