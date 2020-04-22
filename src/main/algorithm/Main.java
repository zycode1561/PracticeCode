package main.algorithm;

import java.util.*;

/**
 * 有n位小朋友去小明家里拜年，小明准备了m份礼物。小明想把所有礼物平均分给每个小朋友，
 * 每个小朋友得到相同个数的礼物。但是m未必能被n整除，小明可以使用以下两种操作任意多次（两种操作可以同时使用）。
 * <p>
 * 1、 给其中一个小朋友发红包，收到红包的小朋友会离开小明家。每个红包需要花费a元。
 * <p>
 * 2、 购买一个新礼物，每个礼物价值为b元。
 * <p>
 * 问小明最少花费多少元，才能使得所有礼物可以被剩下的小朋友平分。
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = countCost(n, m, a, b);
            System.out.println(cost);
        }
        sc.close();
    }

    private static int countCost(int n, int m, int a, int b) {
        int cost = 0 ;
        while(m % n != 0){
            cost += 1;
            n--;
        }
        cost = Math.min(a, b) * cost;
        return cost;
    }
}