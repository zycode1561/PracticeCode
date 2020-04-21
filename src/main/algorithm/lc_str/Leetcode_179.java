package main.algorithm.lc_str;

import java.util.Arrays;

/**
 * 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 解题思路：自定义排序，compare，比较不同顺序两个相加后的数形成的字符串的大小，比较是具有传递性的
 */
public class Leetcode_179 {
    public String largestNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        String res = "";
        for(int i = 0;i < nums.length;i++){
            if(i > 0){
                if(res.equals("0") && nums[i] == 0) continue;
            }
            res = res + nums[i];
        }
        return res;
    }

    private void quickSort(int[] a, int low, int high){
        if(low < high){
            int index = getIndex(a, low, high);
            quickSort(a, low, index - 1);
            quickSort(a,index + 1, high);
        }
    }

    private int getIndex(int[] a, int low, int high){
        int temp = a[low];
        while(low < high){
            while(low < high && compare(a[high],temp)){
                high--;
            }
            a[low] = a[high];
            while(low < high && !compare(a[low],temp)){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        return low;                                              
    }

    private boolean compare(int a, int b){
        String sa = "" + a + b;
        String sb = "" + b + a;
        int minlen = Math.min(sa.length(), sb.length());
        for(int i = 0; i < minlen; i++){
            if(sa.charAt(i) > sb.charAt(i)) return false;
            if(sa.charAt(i) < sb.charAt(i)) return true;
        }
        return true;//若a比b大返回false，其他情况返回true
    }


    public static void main(String[] args) {
        int[] nums = {824,938,1399,5607,6973,5703,9609,4398,8247};
        //int[] nums = {0,21,3};
        Leetcode_179 leetcode_179 = new Leetcode_179();
        leetcode_179.quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
        System.out.println(leetcode_179.compare(824, 938)); 
    }
}