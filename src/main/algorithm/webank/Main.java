package main.algorithm.webank;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            int[][] array = new int[n][2];
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                String[] strs = str.split(" ");
                array[i][0] = Integer.parseInt(strs[0]);
                array[i][1] = Integer.parseInt(strs[1]);
            }
            int money = getMost(array);
            System.out.println(money);
        }
        sc.close();
    }

    private static int getMost(int[][] array) {
        int n = array.length;
        int Money = 0;
        int cards = 1;
        for (int i = 0; i < n; i++) {
            if(array[i][1] != 0){
                cards += array[i][1] - 1;
                Money += array[i][0];
                array[i][0] = 0;
            }
        }
        List<Integer> card0 = new ArrayList<>();
        for (int[] ints : array) {
            if (ints[0] != 0) {
                card0.add(ints[0]);
            }
        }
        Collections.sort(card0,Collections.reverseOrder());
        for(int i = 0; i < Math.min(card0.size(),cards);i++){
            Money += card0.get(i);
        }
        return Money;
    }
}
