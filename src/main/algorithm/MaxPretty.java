package main.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaxPretty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =Integer.parseInt(sc.nextLine());
        while(n > 0){
            String str = sc.nextLine();
            long res = maxCount(str);
            System.out.println(res);
            n--;
        }
    }

    private static long maxCount(String str){
        if(str.length() == 0) return 0L;
        str = str.toLowerCase();
        long res = 0L;
        int c = 26;
        Integer[] nums = new Integer[26];
        Arrays.fill(nums,0);
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            nums[index] += 1;
        }
        Arrays.sort(nums, Collections.reverseOrder());
        for(int num : nums){
            res += c * num;
            c--;
        }
        return res;
    }
}
