package main.algorithm.lc_stack;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
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
