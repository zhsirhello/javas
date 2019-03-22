package offer;

/**
 *大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 */
public class Solution7 {
    public static void main(String[] args){
        Solution7 s = new Solution7();
        int fibonacci = s.Fibonacci(9);
        System.out.println(fibonacci);
    }

    public int Fibonacci(int n) {
        if(n<2){
            return 1;
        }
        int[] arr=new int[n];
        arr[0]=1;
        arr[1]=1;
        int tempor=2;
        while (tempor<n){
            arr[tempor]=arr[tempor-1]+arr[tempor-2];
            tempor++;
        }
        return arr[tempor-1];
    }
    //占用空间少
    public int Fibonacci1(int n) {
        if(n<2){
            return 1;
        }
        int[] arr=new int[n];
        arr[0]=1;
        arr[1]=1;
        int tempor=2;
        while (tempor<n){
            arr[tempor]=arr[tempor-1]+arr[tempor-2];
            tempor++;
        }
        return arr[tempor-1];
    }

}
