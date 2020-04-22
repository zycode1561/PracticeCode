package main.algorithm.lc_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/21
 */
public class UniqueBSTreeII_95 {
    //给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
    //递归
    private List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n <= 0) return res;
        return getAns(1, n);
    }

    private List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        if (start == end) {
            TreeNode node = new TreeNode(start);
            ans.add(node);
            return ans;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = getAns(start, i - 1);
            List<TreeNode> right = getAns(i + 1, end);
            for (TreeNode lNodes : left) {
                for (TreeNode rNodes : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lNodes;
                    root.right = rNodes;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        UniqueBSTreeII_95 ques = new UniqueBSTreeII_95();
        List<TreeNode> res = ques.generateTrees(3);
        for (TreeNode node : res) {
            TraverseTree.preTraverse(node);
            System.out.println();
        }
    }
}
