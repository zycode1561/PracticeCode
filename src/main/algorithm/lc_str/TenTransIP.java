package main.algorithm.lc_str;

public class TenTransIP {
    private static long ipToTen(String ip) {
        String[] nums = ip.split("\\.");
        long n = Long.parseLong(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            n = n << 8;
            n += Long.parseLong(nums[i]);
        }
        return n;
    }

    private static String tenToIP(String num) {
        long temp = Long.parseLong(num);
        String ip = Long.toBinaryString(temp);
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        if (ip.length() > 32) return "invalid number!";
        if (ip.length() < 32) {
            for (int i = 0; i < (32 - ip.length()); i++) {
                sb.append(0);
            }
        }
        sb.append(ip);
        for (int i = 0; i < sb.length() - 8; i += 8) {
            res.append(Integer.parseInt(sb.substring(i, i + 8), 2)).append(".");
        }
        res.append(Integer.parseInt(sb.substring(sb.length() - 8, sb.length()), 2));
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(ipToTen("10.0.3.193"));
        System.out.println(tenToIP("167969729"));
    }
}
