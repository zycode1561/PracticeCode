package main.algorithm.lc_str;

import java.util.*;

//字符串分组
public class GroupAnagrams_50 {
    public List<List<String>>  groupAnagrams (String[] args){
        Map<String,List<String>> map = new HashMap<>();
        for(String str : args){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());

    }
}
