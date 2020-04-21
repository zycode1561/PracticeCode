package main.algorithm.lc_str;

public class LongestPrefix_14 {

    /**
     * 最长公共前缀，selfSolution
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String result = strs[0];
        for (String str : strs) {
            if (str.length() == 0) return "";
            for (int i = 0; i < Math.min(str.length(), result.length()); i++) {
                if (i == str.length() - 1 && str.charAt(i) == result.charAt(i)) {
                    result = result.substring(0, i + 1);
                    break;
                }
                if (str.charAt(i) != result.charAt(i)) {
                    result = result.substring(0, i);
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        String[] strs = {"aaaa", "aa"};
//        System.out.println(longestCommonPrefix(strs));
        String a = "hahahaheiheihei";
        System.out.println(a.indexOf("hahei"));
    }
}