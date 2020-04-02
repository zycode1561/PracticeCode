package main.algorithm;

import java.util.*;

public class Permute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            List<List<Character>> res =  permute(chars);
            for(List<Character> list : res){
                System.out.println(list);
            }
        }
//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.add(1);
//        deque.push(2);
//        deque.poll();
//        deque.pop();
//        Integer peek = deque.peek();
    }

    private static List<List<Character>> permute(char[] chars) {
        List<List<Character>> res = new LinkedList<>();
        List<Character> char_list = new ArrayList<>();
        for(char c : chars){
            char_list.add(c);
        }
        int n = chars.length;
        backtrack(n,char_list,res,0);
        return res;
    }

    private static void backtrack(int n, List<Character> char_list, List<List<Character>> res, int first) {
        if(first == n) res.add(new ArrayList<>(char_list));
        for(int i = first;i < n; i ++){
            Collections.swap(char_list,first,i);
            backtrack(n,char_list,res,first+1);
            Collections.swap(char_list,first,i);
        }
    }
}
