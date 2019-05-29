package leetcode;

/**
 * 数组中的元素表示它可以跳跃几个索引，判断从头开始，是否能跳到最后
 *
 * 贪心算法
 *
 * For example:
 * A =[2,3,1,1,4], returntrue.
 *
 * A =[3,2,1,0,4], returnfalse.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        int maxReach = 0;
        int n=A.length;
        for(int i=0;i<n && i<=maxReach;i++)
            maxReach = Math.max(maxReach,i+A[i]);  /// 跳到该点后还能到达的极限
        if(maxReach<n-1)
            return false;
        return true;
    }
}
