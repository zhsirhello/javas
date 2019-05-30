package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，再给一个字符串数组，数组中字符串长度相同。返回字符串中包含字符串数组所有元素的起始索引。
 * 字符串数组可以打乱顺序组成新字符串。
 */
public class SubstrringWithAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> indexs = new ArrayList<Integer>();
        Map<String, Integer> map_L = new HashMap<String, Integer>();
        Map<String, Integer> map_temp = new HashMap<String, Integer>();
        int wordsnum = L.length,
                wordlen = L[0].length();
        for (String str : L) {
            if(map_L.containsKey(str)){
                map_L.put(str, map_L.get(str)+1);
            }else{
                map_L.put(str, 1);
            }
        }
        for(int i = 0 ; i < S.length()-wordsnum*wordlen+1; i++){
            int count = 0;
            map_temp.clear();
            for(int j = i;j<wordsnum*wordlen+i;j+=wordlen){
                String tmp = S.substring(j, j+wordlen);
                if(map_L.containsKey(tmp)){
                    if(map_temp.containsKey(tmp)){
                        map_temp.put(tmp, map_temp.get(tmp)+1);
                    }else{
                        map_temp.put(tmp, 1);
                    }
                    count++;
                }else{
                    break;
                }
                if(map_temp.get(tmp)>map_L.get(tmp)){
                    break;
                }
                if(count == wordsnum){
                    indexs.add(i);
                }

            }
        }
        return indexs;
    }
}
