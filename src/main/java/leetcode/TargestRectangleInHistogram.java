package leetcode;

/**
 * https://www.nowcoder.com/practice/e3f491c56b7747539b93e5704b6eca40?tpId=46&tqId=29094&tPage=4&rp=4&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking
 * 每个元素代表矩形的高，矩形宽为1，连在一起，最大的矩形面积是多少
 * 一下是笨方法，时间复杂度为n^2
 */
public class TargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; i++){
            int len = 1;
            for(int j = i - 1; j >= 0; j--){
                if(height[j] >= height[i]){
                    len++;
                }else {
                    break;
                }
            }
            for(int k = i + 1; k < height.length; k++){
                if(height[k] >= height[i]){
                    len++;
                }else {
                    break;
                }
            }
            max = Math.max(max,len * height[i]);
        }
        return max;
    }
}
