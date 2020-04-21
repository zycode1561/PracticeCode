package main.algorithm.lc_str;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        int back = 0;//回退目录的数量
        for (int i = paths.length - 1; i >= 0; i--) {
            if(paths[i].equals(""))continue;
            if(!paths[i].equals(".") && !paths[i].equals("..")){
                if(back == 0) stack.push(paths[i]);
                else back--;
            }
            if(paths[i].equals("..")) back++;
        }
        while (!stack.empty()){
            sb.append("/");
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
