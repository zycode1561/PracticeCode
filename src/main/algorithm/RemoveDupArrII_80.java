package main.algorithm;

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
