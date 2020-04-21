package main.algorithm.lc_tree;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/21
 *
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 解法：动态规划，1到n点中找到一个i前面划分为i - 1个点，后面为n - i个点，
 * 分别求出这两个子树的解并且相乘，i从开始到结尾遍历，就可以计算出结果。
 */
public class UBSTreeNum_96 {
    public int numTrees(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        //dp数组，dp[n]表示以1到n为节点组成的二叉树的种类
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
