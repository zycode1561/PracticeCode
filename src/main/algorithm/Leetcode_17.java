package main.algorithm;

import java.util.*;

/**
 * 电话号码的字母组合
 */
public class Leetcode_17 {

    private  Map<Integer, String> map = new HashMap<>();

    private  void initMap() {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    public  List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        initMap();
        if (digits.length() == 0) return res;
        return letterCombinations(digits, 0, digits.length() - 1);
    }

    private  List<String> letterCombinations(String digits, int l, int r) {
        List<String> res = new ArrayList<String>();
        if (l == r) {
            int num = Integer.parseInt(digits.charAt(l) + "");
            String str = map.get(num);
            for (int i = 0; i < str.length(); i++) {
                res.add(str.charAt(i)+"");
            }
            return res;
        }else{
            int mid = (l+r)/2;
            List<String> leftRes = letterCombinations( digits, l,  mid);
            List<String> rightRes = letterCombinations( digits, mid+1,  r);
            return merge(leftRes,rightRes);
        }
    }

    private static List<String> merge(List<String> leftRes, List<String> rightRes) {
        List<String> res = new ArrayList<String>();
        for (String leftRe : leftRes) {
            for (String rightRe : rightRes) {
                res.add(leftRe+rightRe);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String digits = "2345";
        Leetcode_17 leetcode_17 = new Leetcode_17();
        System.out.println(leetcode_17.letterCombinations(digits).toString());
        System.out.println(leetcode_17.letterCombinations(digits).size());
    }
}
