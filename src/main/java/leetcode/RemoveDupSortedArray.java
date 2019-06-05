package leetcode;

/**
 * 删除有序数组中重复的元素，并返回剩余元素个数。
 */
public class RemoveDupSortedArray {
    public int removeDuplicates(int[] A) {
        int n = A.length;
        if(A==null||n<=1)
            return n;
        int count=1;
        for(int i=1;i<n;i++){
            if(A[i]!=A[i-1]){
                A[count++]=A[i];
            }
        }
        return count;
    }
}
