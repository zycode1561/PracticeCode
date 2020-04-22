package main.algorithm.lc_tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/22
 * BST中有两个元素被交换了位置，在不改变树结构的情况下，恢复这个BST
 */
public class RecoverBSTree {
    public void recoverTree(TreeNode root) {
        //用来存储被交换节点的引用，最后直接交换两个节点的值即可
        //pre存储前面的节点，用于比较
        TreeNode node1 = null, node2 = null, pre = null;
        //采用一次中序遍历的方法，找到两个被交换值的节点
        //官方推荐的栈的实现方式
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            //如果出现乱序,说明前面的节点是被交换的节点，看下面的例子
            //1234567 1274563
            //找到第一个节点后，后面节点都是顺序，所以都有node.cal > pre.val
            //直到遇到另一个交换节点时，顺序被打乱，这时是当前节点而不是pre
            //存储节点后直接break就可以了，因为后面的一定满足条件
            if (pre != null && node.val < pre.val) {
                //把node赋值给node2
                node2 = node;
                if (node1 == null) node1 = pre;
                else break;
            }
            pre = node;
            node = node.right;
        }
            //交换节点的值
            swap(node1, node2);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
