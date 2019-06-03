package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 给定一个起始字符串，一个end字符串，然后给定一个字典，每次只可以改变一个字符，从start到end需要多少步
 * bfs,广度优先搜索
 *
 * For example,
 * Given:
 * start ="hit"
 * end ="cog"
 * dict =["hot","dot","dog","lot","log"]
 * As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length5.
 */
public class WordLadder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int res=1;
        LinkedList<String> queue=new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            while(size>0)
            {
                String s=queue.poll();
                size--;

                if(isDiffOne(s, end))
                    return res+1;
                for(Iterator<String> it = dict.iterator(); it.hasNext();)
                {
                    String str=it.next();
                    if(isDiffOne(str, s))
                    {
                        queue.offer(str);
                        it.remove();
                    }

                }
            }
            res++;
        }
        return 0;
    }

    public boolean isDiffOne(String w1, String w2) {
        int count = 0;
        for(int i = 0; i < w1.length(); i++) {
            if(w1.charAt(i) != w2.charAt(i)) {
                count++;
            }
        }
        return count==1?true:false;
    }
}
