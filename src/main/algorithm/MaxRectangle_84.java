package main.algorithm;

import java.util.Stack;

public class MaxRectangle_84 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0;i<heights.length;i++){
            while(stack.peek()!=-1 && heights[stack.peek()] > heights[i]){
                res = Math.max(res,heights[stack.pop()] * (i - 1 - stack.peek()));
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            res = Math.max(res,heights[stack.pop()] * (heights.length - 1 - stack.peek()));
        }

        return res;
    }
}
