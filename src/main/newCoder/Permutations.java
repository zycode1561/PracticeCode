package main.newCoder;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
//        backtrack(nums,res,list,visited);
        backtrack1(nums, res, list, visited);
        return res;
    }

    //正常全排列
    private static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list, int[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
//            if(i > 0 && nums[i] == nums[i - 1])continue;
            list.add(nums[i]);
            visited[i] = 1;
            backtrack(nums, res, list, visited);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }

    //去重全排列
    private static void backtrack1(int[] nums, List<List<Integer>> res, List<Integer> list, int[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) continue;
            list.add(nums[i]);
            visited[i] = 1;
            backtrack1(nums, res, list, visited);
            visited[i] = 0;
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 1,2};
        List<List<Integer>> res = permute(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }

    }
}
