package main.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(res, list, 1, n, k);
        return res;
    }

    private void backtrack(List<List<Integer>> res, LinkedList<Integer> list, int start, int n, int k) {
        if(list.size() == k){
            res.add(new ArrayList<>(list));
        }
        for(int i = start;i <= n;i++){
            list.add(i);
            backtrack(res,list,i+1,n,k);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Combinations_77 combinations_77 = new Combinations_77();
        List<List<Integer>> combine = combinations_77.combine(4, 2);
        for(List<Integer> list : combine){
            System.out.println(list);
        }
    }
}
