package offer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 以下代码为什么不行，对比牛客网的代码，一模一样
 *
 * /////////////运行失败
 */
public class Solution13 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null){
            return false;
        }
        if(root1==null){
            return false;
        }
        boolean flag=false;
        if(root1.val==root2.val){
            flag = subTree(root1,root2);
        }
        if(!flag){
            flag = HasSubtree(root1.left,root2) ||HasSubtree(root1.right,root2);
        }
        return flag;
    }

    public boolean subTree(TreeNode par,TreeNode chi){
        if(chi==null){
            return true;
        }
        if(par==null){
            return false;
        }
        if(par.val!=chi.val){
            return false;
        }else{
            return subTree(par.left,chi.left) && subTree(par.right,par.right);
        }
    }
}
