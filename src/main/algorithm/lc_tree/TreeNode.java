package main.algorithm.lc_tree;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/17
 */
public class TreeNode {
    int val;
    public TreeNode lchild;
    public TreeNode rchild;

    public TreeNode(int val, TreeNode lchild, TreeNode rchild) {
        this.val = val;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
