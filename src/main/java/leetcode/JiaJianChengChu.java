package leetcode;

/**
 * 实现加减乘除
 */
public class JiaJianChengChu {
    public static void main(String[] a){
        System.out.println(new JiaJianChengChu().add(3,15));
    }

    public int add(int a, int b) {
        int sum = a;
        int arr = b;// 表示进位
        while (arr != 0) {
            sum = a ^ b;
            arr = (a & b) << 1;
            a = sum;
            b = arr;
        }
        return sum;
    }

    public int minus(int a, int b) {
        // b为减数,先变成负数
        b = add(~b, 1);
        return add(a, b);
    }

    public int multi(int a, int b) {
        // b为乘数
        for (int i = 0; i < b - 1; i++) {
            a = add(a, a);
        }
        return a;
    }

    public int divide(int dividend, int divisor) {
        // a被除树，b为除数
        int a = dividend;
        int b = divisor;
        if(a==1)
            return 0;
        if(b==0)
            try {
                throw new Exception("被除数不能为0！");
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        int result = 0;
        if (a > 0 && b > 0) {
            while (a > 0) {
                a = minus(a, b);
                if (a >= 0)
                    result++;
            }
            return result;
        } else if (a < 0 && b > 0) {
            a = add(~a, 1);
            return add(~divide(a, b), 1);// 结果变为负号
        } else if (a > 0 && b < 0) {
            b = add(~b, 1);
            return add(~divide(a, b), 1);
        } else if (a < 0 && b < 0) {
            a = add(~a, 1);
            b = add(~b, 1);
            return divide(a, b);
        }
        return result;
    }
}
