package main.algorithm.lc_tree;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/22
 * 验证一颗树是否为二叉搜索树
 * 解法：递归的方法，因为要保证当前节点的左子树的元素全部小于当前元素，右子树的元素全部大于当前元素
 * 所以要保存一个上界和下界，更新这个上下界即可，也可以使用中序遍历的方法，保证数组有序即可
 */
public class ValidateBSTree_98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer low, Integer up) {
        if (root == null) return true;
        int val = root.val;
        if (low != null && val <= low) return false;
        if (up != null && val >= up) return false;
        if (!isValid(root.left, low, val)) return false;
        return isValid(root.right, val, up);
    }

}
