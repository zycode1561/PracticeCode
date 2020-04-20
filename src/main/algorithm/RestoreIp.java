package main.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/20
 */
public class RestoreIp {

    //给定一个纯数字字符串s，找出这串数字可以组成的ip地址
    //回溯法
    private static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4) return res;
        backtrack(s, new LinkedList<>(), 0, res);
        return res;
    }

    private static void backtrack(String s, LinkedList<String> curr, int pos, List<String> res) {
        if (curr.size() == 4) {
            if (pos == s.length()) {
                res.add(String.join(".", curr));
                return;
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (i + pos > s.length()) break;
            String str = s.substring(pos, pos + i);
            if(str.startsWith("0") && str.length() > 1) continue;
            if(Integer.parseInt(str) > 255) continue;
            curr.addLast(str);
            backtrack(s, curr, pos + i, res);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> res = restoreIpAddresses(s);
        System.out.println(res);
    }
}
