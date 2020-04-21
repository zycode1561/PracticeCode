package main.algorithm.lc_array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class RemoveDupArrII_80 {
    private int removeDuplicates(int[] nums) {
        int j = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1};
        RemoveDupArrII_80 removeDupArrII_80 = new RemoveDupArrII_80();
        int n = removeDupArrII_80.removeDuplicates(a);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
