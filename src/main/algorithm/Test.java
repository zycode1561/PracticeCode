package main.algorithm;

import java.util.*;

/**
 *测试类，用于测试一些函数的使用
 */
public class Test {
    public static void main(String[] args) {
        int[] digits = new int[]{9, 23,5346,67,21,1245,8};
        System.out.println(Arrays.toString(digits));
        List<Integer> list = new LinkedList<>();
        int c = 0;
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int n = c + digits[i];
            if (n >= 10) {
                list.add(n - 10);
                c = 1;
            } else {
                list.add(n);
                c = 0;
            }
        }
        if (c == 1) list.add(c);
        Collections.reverse(list);
        int[] res = new int[list.size()];
        int i = 0;
        for(int a : list){
            res[i] = a;
            i++;
        }
        System.out.println(Arrays.toString(res));
        System.out.println("------------");
        String path = "a/b/c//.//./../";
        String[] paths = path.split("/");
        System.out.println(Arrays.toString(paths));
        System.out.println("------");
        System.out.println(Math.sqrt(1));
    }
}
