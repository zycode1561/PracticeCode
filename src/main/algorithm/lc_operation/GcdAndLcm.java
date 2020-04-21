package main.algorithm.lc_operation;

public class GcdAndLcm {
    //最大公约数和最小公倍数

    //最大公约数
    private static long getGcd(long n1, long n2) {
        long gcd = -1;
        if (n1 < n2) {
            n1 = n1 + n2;
            n2 = n1 - n2;
            n1 = n1 = n2;
        }
        if (n1 % n2 == 0) gcd = n2;
        while (n1 % n2 > 0) {
            n1 = n1 % n2;
            if (n1 < n2) {
                n1 = n1 + n2;
                n2 = n1 - n2;
                n1 = n1 = n2;
            }
            if (n1 % n2 == 0) gcd = n2;
        }
        return gcd;
    }

    //最小公倍数
    private static long getLcm(long n1, long n2) {
        return n1 * n2 / getGcd(n1, n2);
    }

    public static void main(String[] args) {
        System.out.println(getGcd(2048,2146473648));
        System.out.println(getLcm(2048,2146473648));
    }
}
