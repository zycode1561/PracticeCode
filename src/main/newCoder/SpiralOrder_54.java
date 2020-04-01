package main.newCoder;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int r = 0;
        int c = 0;
        while (r <= row && c <= col) {
            for (int i = c; i <= col; i++) res.add(matrix[r][i]);
            for (int j = r + 1; j <= row; j++) res.add(matrix[j][col]);
            if (r < row && c < col) {
                for (int i = col - 1; i > c; i--) res.add(matrix[row][i]);
                for (int j = row; j > r; j--) res.add(matrix[j][c]);
            }
            row--;
            col--;
            r++;
            c++;
        }
        return res;
    }
}
