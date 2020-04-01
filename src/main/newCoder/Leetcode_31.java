package main.newCoder;

import java.util.Arrays;
/**
 * 下一个排列
 */
public class Leetcode_31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1)
            return;
        for (int i = 0; i < len - 1; i++) {
            if (isOrder(nums, i)) {
                if (i == 0) {
                    quickSort(nums, 0, len - 1);
                    break;
                } else {
                    int base = nums[i];
                    int index = -1;
                    for (int j = i; j < len; j++) {
                        if (nums[j] > nums[i - 1]) {
                            if (nums[j] <= base) {
                                base = nums[j];
                                index = j;
                            }
                        }
                    }
                    swap(i - 1, index, nums);
                    quickSort(nums, i, len - 1);
                    break;
                }
            } else {
                if (i == len - 2)
                    swap(i, len - 1, nums);
            }
        }
    }

    private boolean isOrder(int[] nums, int low) {
        for (int i = low; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                return false;
        }
        return true;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int index = getIndex(nums, low, high);
            quickSort(nums, low, index - 1);
            quickSort(nums, index + 1, high);
        }
    }

    private int getIndex(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= temp)
                high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= temp)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Leetcode_31 leetcode_31 = new Leetcode_31();
        int[] nums = { 1, 1 };
        leetcode_31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}