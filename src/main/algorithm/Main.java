package main.algorithm;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }



    private static String delStr(String str) {
        if (str.length() == 0) return "";
        int[] chars = new int[26];
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Arrays.fill(chars, 0);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            chars[c - 97] += 1;
        }
        int min = Integer.MAX_VALUE;
        for (int n : chars) {
            if (n != 0) {
                min = Math.min(min, n);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == min) {
                list.add((char) (i + 97));
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (list.contains(c)) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }


    /**
     * 喝饮料
     *
     * @param num 输入空瓶子数
     * @return 返回可以的瓶数
     */
    private static int drinking(int num) {
        if (num < 2) return 0;
        if (num == 2) return 1;
        int exchange = num / 3;
        int left = num % 3;
        return exchange + drinking(exchange + left);
    }


    /**
     * 获取转换后的密码
     *
     * @param password 输入明文密码
     * @return 返回转换后的密码
     */
    private static String formatPassword(String password) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c == 'Z') {
                sb.append('a');
                continue;
            }
            if (c >= 'A' && c <= 'Y') {
                char s = (char) (c + 33);
                sb.append(s);
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                if (c <= 'c') {
                    sb.append(2);
                } else if (c <= 'f') {
                    sb.append(3);
                } else if (c <= 'i') {
                    sb.append(4);
                } else if (c <= 'l') {
                    sb.append(5);
                } else if (c <= 'o') {
                    sb.append(6);
                } else if (c <= 's') {
                    sb.append(7);
                } else if (c <= 'v') {
                    sb.append(8);
                } else {
                    sb.append(9);
                }
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}