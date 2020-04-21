package main.algorithm.dp;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/21
 * <p>
 * 题目：给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 解题思路：
 *     动态规划，从后向前考虑，因为是交错执行，所以s3最后一个字符一定等于s1或者s2最后一个字符
 *     判断相等之后，相等的两个字符串分别向前移动一个位置，再进行判断，也就是说，结果是依赖于前面的结果的
 *     也就是形成了最优子结构，如果同时和s1，s2都相等，那么就把二者的结果去或，换句话来说，
 *     只要是有一个结果是满足条件的，那么整个问题就是满足条件的，同时题目中还含有一个隐含条件，那就是
 *     匹配的s3的下标，一定是s1的当前长度 + s2的当前长度 - 1（下标要减1），所以我们就可以把三维的数组降到二维
 */
public class StaggeredStr {
    private static boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        //如果s3的长度不等于s1和s2长度之和，直接返回错误
        if(l3 != l1 + l2) return false;
        //dp[l1][l2]表示s1的前l1个字符和s2的前l2个字符是否可以和s3的前l1+l2个字符交错匹配
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        //初始化base条件
        dp[0][0] = true;
        //初始化，注意下标要减1
        //如果当前不想等直接false，前面是false也是false，所以直接取与
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = dp[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }

        //dp方程，取决于前一个状态，并且当前字符是否可以和s1,s2中任意一个的对应位置匹配，取或
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int k = i + j;
                dp[i][j] = (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(k - 1)))
                        || (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(k - 1)));
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        boolean interleave = isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(interleave);
    }
}
