package main.algorithm;

import java.util.Scanner;

public class QuickPow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] nums = str.split(" ");
            int n = Integer.parseInt(nums[0]);
            int l = Integer.parseInt(nums[1]);
            if (n == 0) {
                System.out.println();
                continue;
            }
            long res = getIdNum(n, l);
            System.out.println(res);
        }
        sc.close();
//        System.out.println(pow(5, 3));
    }

    private static long getIdNum(int n, int l) {
        long res = 0;
        for (int i = 1; i <= l; i++) {
            res += pow(n, i);
        }
        return res % 1000000007L;
    }

    private static long pow(int aa, int bb) {
        long res = 1;
        long a = aa, b = bb;
        a %= 1000000007L;
        for (; b != 0; b /=2) {
            if(b % 2 == 1){
                res = (res * a) % 1000000007L;
            }
            a = (a * a) % 1000000007L;
        }
        return res;
    }
}
