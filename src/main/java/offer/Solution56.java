package offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串”bcced”的路径，但是矩阵中不包含”abcb”路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 这是一个可以用回朔法解决的典型题。
 * //1. 首先，在矩阵中任选一个格子作为路径的起点。如果路径上的第i个字符不是ch，那么这个格子不可能处在路径上的第i个位置。
 * 如果路径上的第i个字符正好是ch，那么往相邻的格子寻找路径上的第i+1个字符。除在矩阵边界上的格子之外，其他格子都有4个相邻的格子。
 * 重复这个过程直到路径上的所有字符都在矩阵中找到相应的位置。
 * //2. 由于回朔法的递归特性，路径可以被开成一个栈。当在矩阵中定位了路径中前n个字符的位置之后，在与第n个字符对应的格子的周围
 * 都没有找到第n+1个字符，这个时候只要在路径上回到第n-1个字符，重新定位第n个字符。
 * //3. 由于路径不能重复进入矩阵的格子，还需要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入每个格子。
 * 当矩阵中坐标为（row,col）的格子和路径字符串中相应的字符一样时，从4个相邻的格子(row,col-1),(row-1,col),(row,col+1)以及
 * (row+1,col)中去定位路径字符串中下一个字符
 * //4. 如果4个相邻的格子都没有匹配字符串中下一个的字符，表明当前路径字符串中字符在矩阵中的定位不正确，我们需要回到前一个，
 * 然后重新定位。
 * //5. 一直重复这个过程，直到路径字符串上所有字符都在矩阵中找到合适的位置
 *
 */
public class Solution56 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null || rows<=0 || cols<=0 || str==null){
            return false;
        }
        if(str.length==0){
            return true;
        }
        boolean[] visited = new boolean[matrix.length];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(findPath(matrix, i, j, rows, cols, 0, visited, str)){
                    return true;
                }
            }
        }
        return false;
    }

    //尝试寻找路径
    public boolean findPath(char[] matrix, int row, int col, int rows, int cols, int k, boolean[] visited, char[] str){
        if(row<0 || row>=rows || col<0 || col>=cols || str[k]!=matrix[row*cols+col] || visited[row*cols+col]){
            return false;
        }
        if(k==str.length-1){
            return true;
        }
        visited[row*cols+col] = true;
        if(findPath(matrix, row+1, col, rows, cols, k+1, visited, str) || findPath(matrix, row, col+1, rows, cols, k+1, visited, str) || findPath(matrix, row-1, col, rows, cols, k+1, visited, str) || findPath(matrix, row, col-1, rows, cols, k+1, visited, str)){
            return true;
        }
        visited[row*cols+col] = false;
        return false;
    }
}
