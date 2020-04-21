package main.algorithm.lc_array;

public class SpiralOrderII_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row = n - 1;
        int col = n - 1;
        int r = 0;
        int c = 0;
        int num = 1;
        while (r <= row && c <= col) {
            for (int i = c; i <= col; i++) {
                res[r][i] = num;
                num++;
            }
            for (int j = r + 1; j <= row; j++) {
                res[j][col] = num;
                num++;
            }
            if (r < row && c < col) {
                for (int i = col - 1; i > c; i--) {
                    res[row][i] = num;
                    num++;
                }
                for (int j = row; j > r; j--) {
                    res[j][c] = num;
                    num++;
                }
            }

            row--;
            col--;
            r++;
            c++;
        }
        return res;
    }
}
