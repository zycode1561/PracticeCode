package main.algorithm.dp;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/19
 *
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 */
public class DecodeWays_91 {
    public static void main(String[] args) {
        int i = numDecodings("12014120");
        System.out.println(i);
    }

    private static int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        if (chars[0] == '0') return 0;
        if (chars.length == 1) return 1;
        dp[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0') {
                if (chars[i - 1] == '0' || chars[i - 1] > '2') return 0;
                else {
                    if (i == 1){
                        dp[i] = 1;
                    }else dp[i] = dp[i - 2];
                }
            } else if ((chars[i - 1] == '1' || (chars[i - 1] == '2' && (chars[i] >= '1' && chars[i] <= '6')))) {
                if(i == 1){
                    dp[i] = dp[i - 1] + 1;
                    continue;
                }
                dp[i] = dp[i - 1] + dp[i - 2];
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[chars.length - 1];
    }
}
