package main.algorithm.lc_tree;

import java.util.Stack;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/17
 */
public class TraverseTree {

    //二叉树中序遍历非递归
    public static void midTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()){
            while (node != null) {
                stack.push(node);
                node = node.lchild;
            }

            if (!stack.empty()) {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.rchild;
            }
        }
    }

    //二叉树前序遍历非递归
    public static void preTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()){
            while (node != null) {
                System.out.print(node.val + " ");
                stack.push(node);
                node = node.lchild;
            }

            if (!stack.empty()) {
                node = stack.pop();
                node = node.rchild;
            }
        }
    }


}
