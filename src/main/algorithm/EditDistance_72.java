package main.algorithm;

public class EditDistance_72 {
    public int minDistance(String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int l1 = word1.length();
        int l2 = word2.length();
        //如果二者有一个为空，直接返回另一个字符串的长度
        if (l1 == 0) return l2;
        if (l2 == 0) return l1;
        //动态规划，dp[i][j]表示word1的前i个字符与word2的前j个字符的最小编辑距离
        int[][] dp = new int[l1 + 1][l2 + 1];
        //初始化dp数组
        //当二者有一个为0时，等于另一个的长度
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= l2; j++) {
            dp[0][j] = j;
        }
        //依照问题和子问题的关系遍历dp数组
        //画图可知，是正向遍历
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                //若当前位置的字符相等，因为是下标，所以要减1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {//若不想等
                    //三种操作，插入（dp[i - 1][j]），删除（dp[i][j-1]），替换（dp[i-1][j-1]）
                    //获取三者最小值，加上操作数1
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[l1][l2];
    }
}
