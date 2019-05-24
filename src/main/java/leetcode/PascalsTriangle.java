package leetcode;

import java.util.ArrayList;


/**
 * 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例: 输入: 3(第四层) 输出: [1,3,3,1]        0是第一层
 */
public class PascalsTriangle {
    public static void main(String[] ars){
        ArrayList<Integer> list = new PascalsTriangle().getRow(2);
        for(Integer i:list){
            System.out.print(i+" ");
        }
    }

    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row=new ArrayList<Integer>();
        rowIndex++;
        if(rowIndex==0)
            return row;
        row.add(1);
        for(int i=1;i<rowIndex;i++)
        {
            for(int j=i-1;j>0;j--)
            {
                row.set(j, row.get(j-1)+row.get(j));
            }
            row.add(1);
        }
        return row;
    }
}
