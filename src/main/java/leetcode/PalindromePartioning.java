package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 给定一个字符串，求其所有可能的回环数组合。
 * “aab”
 *      ["aa","b"],
 *      ["a","a","b"]
 */
public class PalindromePartioning {
    //回溯法。时间与空间都超过要求
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s == null || s.length() == 0)
            return res;

        solve(s, 0, new ArrayList<String>(), res);
        return res;
    }

    private void solve(String s, int index, ArrayList<String> preList, ArrayList<ArrayList<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<String>(preList));
            return;
        }
        ArrayList<String> list = new ArrayList<String>(preList);
        for (int i = index + 1; i <= s.length(); i++) {
            if (isPalindrom(s.substring(index, i))) {
                list.add(s.substring(index, i));
                solve(s, i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrom(String s) {
        if (s == null)
            return false;

        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;

    }

    //动态规划算法
    public ArrayList < ArrayList<String> > partition1(String s) {
        ArrayList < ArrayList<String> > result = new ArrayList<>();
        ArrayList<String> nullAL = new ArrayList<>();
        result.add(nullAL);
        int strLength = s.length();
        // 遍历s中每个字符
        for (int i = 0; i < strLength; i++) {
            String palindrome = String.valueOf(s.charAt(i));
            ArrayList < ArrayList<String> > additionResult = new ArrayList<>();
            for (ArrayList<String> resultAL : result) {
                int resultALSize = resultAL.size();
                // 如果能和最后一个字符串相等，那么该字符串与最后一个字符串可以构成回文，新建一个list，存储这种情况。
                if (resultALSize > 0 && resultAL.get(resultALSize-1).equals(palindrome)) {
                    ArrayList<String> additionAL = new ArrayList<>(resultAL);
                    additionAL.set(resultALSize-1, additionAL.get(resultALSize-1)+palindrome);
                    additionResult.add(additionAL);
                }
                // 如果能和倒数第二个字符串相等，那么倒数两个字符串与该字符可以构成回文，新建一个list，存储这种情况
                if (resultALSize > 1 && resultAL.get(resultALSize-2).equals(palindrome)) {
                    ArrayList<String> additionAL = new ArrayList<>(resultAL.subList(0, resultALSize-2));
                    additionAL.add(palindrome+resultAL.get(resultALSize-1)+palindrome);
                    additionResult.add(additionAL);
                }
                // 这个字母一定为回文，记录这种情况
                resultAL.add(palindrome);
            }
            result.addAll(additionResult);
        }
        // 这题坑爹，最后的结果要按每个list中字符串的字典序排列，排列不对不给过
        Collections.sort(result, new Comparator<ArrayList < String > >() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                int o1Size = o1.size();
                int o2Size = o2.size();
                int count = o1Size < o2Size ? o1Size : o2Size;
                for (int i = 0; i < count; i++) {
                    if (o1.get(i).compareTo(o2.get(i)) != 0) {
                        return o1.get(i).compareTo(o2.get(i));
                    }
                }
                return Integer.compare(o1Size, o2Size);
            }
        });

        return result;
    }
}
