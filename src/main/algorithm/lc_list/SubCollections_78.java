package main.algorithm.lc_list;

import java.util.ArrayList;
import java.util.List;

public class SubCollections_78 {
    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res.add(new ArrayList<>(list));
        if(nums.length == 0) return res;
        for (int num : nums) {
            List<List<Integer>> store = new ArrayList<>();
            for (List<Integer> integers : res) {
                List<Integer> temp = new ArrayList<>(integers);
                temp.add(num);
                store.add(temp);
            }
            res.addAll(store);
            store.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        SubCollections_78 subCollections_78 = new SubCollections_78();
        int[] a = {1,2,2};
        List<List<Integer>> res = subCollections_78.subsets(a);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
