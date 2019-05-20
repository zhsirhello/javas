package dazahui;

public class Gys {
    public static void main(String[] a){
        long l = gcd(42, 28);
        long l1 = gbd(42, 28);
        System.out.println(l);
        System.out.println(l1);
    }

    public static long gcd(long x,long y){
        if(y==0){
            return x;
        }else {
            return gcd(y,x%y);
        }
    }

    public static long gbd(long x,long y){
        return x*y/gcd(x,y);
    }
}
