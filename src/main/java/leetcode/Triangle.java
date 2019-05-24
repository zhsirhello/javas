package leetcode;

import java.util.ArrayList;

/**\
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 *
 * 类似如上，返回每层最小值相加的数。
 * 不理解为什么可以如下做，从倒数第二层开始，每个值加上更下一层相邻的较小值。最终就是每层最小值加到第一层的和。为什么会这样？
 */
public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i --) {
            for (int j = 0; j < triangle.get(i + 1).size() - 1; j ++) {
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }
        return triangle.get(0).get(0);
    }
}
