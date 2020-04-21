package main.algorithm.lc_stack;

import java.util.*;
/**
 * 有效的括号
 */
public class ValidParentheses_20 {
    private boolean isValid(String s) {
        if (s.length() == 0)
            return true;
        if (s.length() % 2 != 0)
            return false;
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else
                    return false;
            }
            if (s.charAt(i) == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else
                    return false;
            }
            if (s.charAt(i) == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else
                    return false;
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        ValidParentheses_20 leetcode_20 = new ValidParentheses_20();
        String s = "([)]";
        System.out.println(leetcode_20.isValid(s));
    }
}