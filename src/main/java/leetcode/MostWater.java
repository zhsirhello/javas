package leetcode;

/**
 * 数组的元素表示一条线，线和线之间可以装水，找到两条线，与x轴围起来，问最多装多少水
 */
public class MostWater {
    public int maxArea(int[] height) {
        if (height.length<2){
            return 0;
        }

        int left = 0;
        int right = height.length-1;
        int maxV = 0;

        while (left<right){
            int v = Math.min(height[left],height[right])*(right-left);
            maxV = Math.max(v,maxV);
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }

        return maxV;
    }
}
