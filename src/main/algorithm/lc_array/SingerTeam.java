package main.algorithm.lc_array;

import java.util.Arrays;
import java.util.Scanner;

public class SingerTeam {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] tall = new int[n];
            for (int i = 0; i < tall.length; i++) {
                tall[i] = sc.nextInt();
            }
            int res = removeNum(tall);
            System.out.println(res);
        }
//        int[] a = {186, 186, 150, 200, 160, 130, 197, 200};
//        System.out.println(rise(a,3));
    }

    /**
     * 以i为分界限，求出以i为界限的左边最长递增子序列和最右最长递减子序列的长度之和
     * 取最大值k，返回tall.length - k
     *
     * @param tall 身高数组
     * @return 最少需要移除的人数
     */
    private static int removeNum(int[] tall) {
        if (tall.length == 0) return 0;
        int[] rise = new int[tall.length];
        int[] down = new int[tall.length];
        Arrays.fill(rise,1);
        Arrays.fill(down,1);
        int res = 0;
        //最长递增
        for (int a = 1; a < tall.length; a++) {
            for (int b = 0; b < a; b++) {
                if (tall[b] <tall[a] ) {
                    rise[a] = Math.max(rise[a], rise[b] + 1);
                }
            }
        }
        //最长递减
        for (int a = tall.length - 2; a >= 0; a--) {
            for (int b = tall.length - 1; b > a; b--) {
                if (tall[b] < tall[a] ) {
                    down[a] = Math.max(down[a], down[b] + 1);
                }
            }
        }
        for (int i = 0; i < tall.length; i++) {
            res = Math.max(res, rise[i] + down[i] - 1);
        }
        return tall.length - res;
    }
}
