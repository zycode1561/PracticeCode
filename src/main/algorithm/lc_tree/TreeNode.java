package main.algorithm.lc_tree;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/17
 */
public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode lchild, TreeNode rchild) {
        this.val = val;
        this.left = lchild;
        this.right = rchild;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
