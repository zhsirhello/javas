package offer;

import java.util.Arrays;

/**
 *输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution19 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length<=0){
            return false;
        }
        int len=sequence.length;
        int root=sequence[len-1];
        int i=0;
        for(;i<len-1;i++){
            if(root<=sequence[i])
                break;
        }
        int j=i;
        for(;j<len-1;j++){
            if(root>sequence[j]){
                return false;
            }
        }
        boolean leftFlag=true;

        if (i>0) {
            //copyRange方法，包含第二个索引不包括第三个索引
            leftFlag=VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,i));

        }
        boolean rightFlag=true;
        if (i<len-1) {
            rightFlag=VerifySquenceOfBST(Arrays.copyOfRange(sequence,i,sequence.length-1));
        }
        return leftFlag&&rightFlag;
    }

    //如果Arrays.copyOfRange编译无法通过，则使用如下方法实现相同功能
    public int[] getArray(int[] arr,int begin,int end){
        int[] areturn = new int[end-begin];
        for(int i=begin;i<end;i++){
            areturn[i-begin]=arr[i];
        }
        return areturn;
    }
}
