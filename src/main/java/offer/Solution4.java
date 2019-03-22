package offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution4 {
    public static void main(String[] args){
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node = reConstructBinaryTree(pre, in);
        preOrder(node);
        System.out.println("=======");
        middleOrder(node);
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = new TreeNode(pre[0]);
        int len=pre.length;
        if(len==1){
            root.left=null;
            root.right=null;
            return root;
        }
        int middle=0;
        for(int i=0;i<len;i++){
            if(pre[0]==in[i]){
                middle=i;
                break;
            }
        }
        //左子树
        if(middle>0){
            int[] a1= new int[middle];
            int[] a2= new int[middle];
            for(int j=0;j<middle;j++){
                a1[j]=pre[j+1];
                a2[j]=in[j];
            }
            TreeNode left = reConstructBinaryTree(a1, a2);
            root.left=left;
        }else{
            root.left=null;
        }
        //右子树
        if(len-middle-1>0){
            int[] a1= new int[len-middle-1];
            int[] a2= new int[len-middle-1];
            for(int j=0;j<len-middle-1;j++){
                a1[j]=pre[middle+1+j];
                a2[j]=in[middle+1+j];
            }
            root.right=reConstructBinaryTree(a1,a2);
        }else {
            root.right=null;
        }
        return root;
    }
    //前序遍历
    public static void preOrder(TreeNode root){
        if(null!=root){
            System.out.print(root.val+"\t");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历
    public static void middleOrder(TreeNode root){
        if(null!=root){
            middleOrder(root.left);
            System.out.print(root.val+"\t");
            middleOrder(root.right);
        }
    }
}
