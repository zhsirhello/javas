package leetcode;

/**
 * 一个圈，第i个点有油量gas[i],从第i点到第i+1点，花费油量cost[i]，问：能否有一个点支持走完这一圈。有返回起始点，无返回-1
 * 贪心算法
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length <= 0 || cost.length <= 0)
            return -1;

        int index = -1, remain = 0, total = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            remain += gas[i] - cost[i];
            // 如果本次剩余<0,说明不能由i走到i+1
            if(remain < 0){
                remain = 0;
                index = i;
            }
        }
        return total >= 0 ? index + 1 : -1;
    }
}
