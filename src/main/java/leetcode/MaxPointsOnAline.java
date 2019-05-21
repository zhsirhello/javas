package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 求二维平面上所有点连成直线最多的点是多少
 * 1、如果点重合，算多个点。
 * 2、注意垂直的点，因为除数为0，不好计算，所以单独列出来。
 * 3、整体使用hashmap装点，双层for循环，斜率为key,点数为value
 */
public class MaxPointsOnAline {
    public int maxPoints(Point[] points) {
        int n = points.length;
        if(n < 2) return n;

        int ret = 0;
        for(int i = 0; i < n; i++) {
            // 分别统计与点i重合以及垂直的点的个数
            int dup = 1, vtl = 0;
            Map<Float, Integer> map = new HashMap<>();
            Point a = points[i];

            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                Point b = points[j];
                if(a.x == b.x) {
                    if(a.y == b.y) dup++;
                    else vtl++;
                } else {
                    float k = (float)(a.y - b.y) / (a.x - b.x);
                    if(map.get(k) == null) map.put(k, 1);
                    else map.put(k, map.get(k) + 1);
                }
            }

            int max = vtl;
            for(float k: map.keySet()) {
                max = Math.max(max, map.get(k));
            }
            ret = Math.max(ret, max + dup);
        }
        return ret;
    }
}
class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
