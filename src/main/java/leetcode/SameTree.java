package leetcode;

/**
 * 判断两颗树是否相等，结构与各个节点的值。
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if ((p == null && q != null) ||(p!=null&&q==null)||p.val!=q.val){
            return false;
        }
        return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
