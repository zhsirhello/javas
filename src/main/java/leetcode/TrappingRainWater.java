package leetcode;

/**
 * 数组表示柱子高，宽为1，问，可以积水多少。
 * 如...2，0，2...这三个元素就积水4.
 */
public class TrappingRainWater {
    public int trap(int heights[], int n) {
        int maxhigh=0;
        int left=0,right=0;
        for(int i=0;i<n;i++)//找到最大值的下标
        {
            if(heights[i]>heights[maxhigh])
                maxhigh=i;
        }
        int sum=0;
        for(int i=0;i<maxhigh;i++)//计算左边的容量
        {
            if(heights[i]<left)
                sum+=(left-heights[i]);
            else
                left=heights[i];
        }

        for(int j=n-1;j>maxhigh;j--)//计算右边的容量
        {
            if(heights[j]<right)
                sum+=(right-heights[j]);
            else
                right=heights[j];
        }
        return sum;
    }
}
