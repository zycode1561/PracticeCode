package main.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/18
 */
public class SubSets_90 {
    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(res, nums, list, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, int[] nums, LinkedList<Integer> list, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) continue;
            list.add(nums[i]);
            backtrack(res, nums, list, i + 1);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
