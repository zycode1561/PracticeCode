package main.algorithm;

public class CanJump_55 {
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
