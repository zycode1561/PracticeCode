package main.algorithm;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int n = Integer.parseInt(String.valueOf(str.charAt(0)));
            int m = Integer.parseInt(String.valueOf(str.charAt(2)));
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < m; j++) {
                    map[j][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                }
            }
            getMinDistance(map);
            for (int[] a : map) {
                for (int num : a) {
                    System.out.print(num + " ");
                    System.out.println();
                }
            }
        }
        sc.close();
    }

    private static void getMinDistance(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 0) {
                    map[i][j] = dfs(map, i, j);
                }
            }
        }
    }

    private static int dfs(int[][] map, int i, int j) {
        if (i < 0 && j < 0 && i >= map.length && j >= map.length) return 0;
        else if(i >= 0 && j >= 0 && map[i][j] == 0) return 0;
        else {
            return Math.min(Math.min(dfs(map, i, j + 1), dfs(map, i, j - 1)),
                    Math.min(dfs(map, i + 1, j), dfs(map, i - 1, j))) + 1;
        }
    }
}