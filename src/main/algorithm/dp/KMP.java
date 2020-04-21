package main.algorithm.dp;

public class KMP {
    private int[][] dp;
    private String pat;

    private KMP(String pat){
        this.pat = pat;
        int M = pat.length();
        //dp[状态][字符] = 下一个状态
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        //影子状态X 初始为0
        int X = 0;
        //构建状态转移图
        for(int j = 1; j< M;j++){
            for(int c=0;c<256;c++){
                dp[j][c] = dp[X][c];
            }
            dp[j][pat.charAt(j)] = j + 1;//推进状态，直接加1
            //更新影子状态
            X = dp[X][pat.charAt(j)];//如果无法匹配，影子状态也会回退，但是是已经计算过的
        }
    }

    private int search(String txt){
        int M = pat.length();
        int N = txt.length();
        //pat 的初始状态为0
        int j = 0;
        for(int i = 0;i<N;i++){
            j = dp[j][txt.charAt(i)];
            if(j == M) return i - M + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP("aaab");
        System.out.println(kmp.search("aaaaaaab"));
    }
}
