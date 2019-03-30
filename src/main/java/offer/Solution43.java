package offer;

/**
 * 数组中重复的数字。
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 *
 * 技巧：所有数字都在0~n-1的范围内，由此借助一个n范围的数组。时间复杂度n，空间复杂度n
 *
 * 还有一个方法空间复杂度为1，稍难理解
 */
public class Solution43 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int[] tempor=new int[length];
        for(int i=0;i<length;i++){
            int index = numbers[i];
            if(tempor[index]==0){
                tempor[index]++;
            }else{
                duplication[0]=index;
                return true;
            }
        }
        return false;
    }



    public boolean duplicate2(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 0) {
            return false;
        }

        for(int i = 0; i < length; i++) {
            while(numbers[i] != i) {
                if(numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return false;
    }
}
