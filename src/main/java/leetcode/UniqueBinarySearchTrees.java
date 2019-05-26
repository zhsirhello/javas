package leetcode;

/**
 * 给定一个n，即有1~n个数，求构成二叉搜树的个数
 *
 * 链接：https://www.nowcoder.com/questionTerminal/b2b6734cbc0b43088f6084785046b861
 * 来源：牛客网
 *
 * 思路：
 *     考虑根节点，设对于任意根节点k，有f(k)种树的可能。
 *     比k小的k-1个元素构成k的左子树。则左子树有f(k-1)种情况。
 *     比k大的n-k个元素构成k的右子树。则右子树有f(n-k)种情况。
 *     易知，左右子树相互独立，所以f(k)=f(k-1)*f(n-k)。
 *     综上，对于n，结果为k取1,2,3,...,n时，所有f(k)的和。
 * 代码思路：
 *     根据上述思路可以用简单的递归方法快速解决。
 *     现在考虑非递归解法，用数组记录每个f(i)的值，记f(0)=1,f(1)=1。
 *     根据公式：f(k)=f(k-1)*f(n-k)，访问数组中的元素。
 *     循环求和，结果更新到数组中。
 * (PS:此题可用Catalan number快速求解：对于n，答案为1/(n+1)*nC2n。)
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 0)
            return 0;
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                res[i] += res[j - 1] * res[i - j];
            }
        }

        return res[n];
    }

    //递归  选择一个节点，它的左右子树个数的乘积就是总的个数，可以递归解决
    public int numTrees1(int n) {
        if(n <= 1)
            return 1;
        int uniqueBST = 0;
        for(int i = 1; i <= n; i++){
            uniqueBST += numTrees(i-1)*numTrees(n-i);
        }
        return uniqueBST;
    }
}
