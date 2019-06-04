package leetcode;

/**
 * 折半查找法在循环数组中的应用
 * 链接：https://www.nowcoder.com/questionTerminal/d942d1aabf5549b0b53af55f1d4432e4
 * 来源：牛客网
 *
 * 有重复元素的情况下，如果A[mid]>A[l]，能确定mid出于左半部，如果A[mid]<A[l]能确定mid
 * //处于右半部，但是A[mid]==A[l]时，则mid左半部右半部都有可能，因此只能l++遍历。
 */
public class SearchInRotatedSortedArray {
    public boolean search(int A[],  int target) {
        int n=A.length;
        int l=0,r=n-1;
        while(r>=l){
            int mid=l+(r-l)/2;
            if(A[mid]==target) return true;
            if(A[mid]>A[l]){
                if(A[l]<=target&&target<A[mid]) r=mid-1;
                else l=mid+1;
            }else if(A[mid]<A[l]){
                if(A[mid]<target&&target<=A[r]) l=mid+1;
                else r=mid-1;
            }else l++;
        }
        return false;
    }
}
