package main.algorithm;

import java.util.Arrays;

//用n个数的n-1阶乘来分组，判断每个数是在哪一组，递归判断，
//用一个visited数组记录访问过的数字，按照顺序往结果数组中插入
public class KPermutation_60 {
    public String getPermutation(int n, int k) {
        int[] res = new int[n];
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n];
        permute(n, k - 1, visited, res, 0);
        for (int a : res) {
            sb.append(a);
        }
        return sb.toString();
    }

    private void permute(int n, int k, boolean[] visited, int[] res, int index) {
        if (n == 0) return;
        int fac = factorial(n - 1);
        int num = k / fac; //找出阶乘处于哪一组
        int c = 0;
        int i = 0;
        while (i < visited.length && c <= num) {
            if (!visited[i]) c++;
            i++;
        }
        res[index] = i;
        visited[i - 1] = true;
        permute(n - 1, k % fac, visited, res, index + 1);
    }

    private int factorial(int n) {
        if (n == 0) return 0;
        int res = 1;
        while (n > 1) {
            res *= n;
            n--;
        }
        return res;
    }
}
