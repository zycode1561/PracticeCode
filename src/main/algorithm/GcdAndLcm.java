package main.algorithm;

public class GcdAndLcm {
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

    private static long getLcm(long n1, long n2) {
        return n1 * n2 / getGcd(n1, n2);
    }

    public static void main(String[] args) {
        System.out.println(getGcd(2048,2146473648));
        System.out.println(getLcm(2048,2146473648));
    }
}
