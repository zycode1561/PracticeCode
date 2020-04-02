package main.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 动态规划
 */
public class Leetcode_22 {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        Leetcode_22 leetcode_22 = new Leetcode_22();
        // System.out.println(leetcode_22.generateParenthesis(3).toString());
        int a1 = 12;
        a1 = -a1;
        String a = "a" + a1;
        System.out.println(a);
    }
}