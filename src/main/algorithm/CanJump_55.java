package main.algorithm;

public class CanJump_55 {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个位置。
     *
     * @param nums 给定一个非负整数数组
     * @return 是否能够到达最后一个位置
     */
    public boolean canJump(int[] nums) {
        int k = 0;
        for(int i = 0;i < nums.length;i++){
            if(i > k) return false;
            if(k >= nums.length) break;
            k = Math.max(k,i+nums[i]);
        }
        return true;
    }
}
