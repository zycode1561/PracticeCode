package main.newCoder;

import java.util.*;

public class Solution {

    private static Set<Integer> nums = new HashSet<Integer>();
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int[] nums = new int[10];
    //     // for(int i = 0;i < 10;i++){
    //     //     nums[i] = sc.nextInt();
    //     // }
    //     String[] strs = {"aabz","ddd","bde","aabc"};
    //     Arrays.sort(strs,new Comparator<String>(){

    //         @Override
    //         public int compare(String o1, String o2) {
    //             // TODO Auto-generated method stub
    //             if(o1.charAt(o1.length()-1) != o2.charAt(o2.length()-1)) return (o1.charAt(o1.length()-1) - o2.charAt(o2.length()-1));
    //             // if(o1.charAt(0) == o2.charAt(0))return o1.length() - o2.length();
    //             return o1.compareTo(o2);
    //         }

           
    //     });

    //     // Arrays.sort(nums);
    //     System.out.println(Arrays.toString(strs));
    // }

    
    private static List<String> list = new ArrayList<>();

    public static void saveString(String str) {
        if (str.length() == 0 && str == null)
            return;
        int l = str.length();
        int i;
        for (i = 0; i + 8 < l; i += 8) {
            String s = str.substring(i, i + 8);
            list.add(s);
        }
        if (i == l)
            return;
        else {
            for (int j = 0; j < i - l; j++) {
                str = str + 0;
            }
        }
        list.add(str.substring(i - 8, i));
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        String[] nums = num.split("\\.");
        if(nums.length == 1) System.out.print(nums[0]);
        String last = nums[1];
        if(last.charAt(0) < '5'){
            System.out.print(nums[0]);
        }else{
            System.out.print(Integer.parseInt(nums[0])+1);
        }
    }



}
