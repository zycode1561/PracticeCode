package main.algorithm;

import java.util.Arrays;

public class ThreeSumClosest_16 {

    /**
     * 最接近的三数之和
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                else if (sum < target) L++;
                else if (sum > target) R--;
                else return sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,8,16,32,64,128};
        int target = 82;
        System.out.println(threeSumClosest(nums, target));
    }
}
