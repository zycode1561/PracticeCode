package main.algorithm.lc_list;

import main.algorithm.lc_list.ListNode;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/19
 */
public class ReverseNodeII_92 {

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        //递归思想，直到遍历到反转节点，m==1，其余时间一直next
        head.next = reverseBetween(head.next, m - 1, n - 1);

        return head;
    }

    //存储第n个节点之后的节点，因为要让头节点指向它
    private static ListNode backNode = null;

    //反转从链表开始节点的n个节点
    private static ListNode reverseN(ListNode head, int n) {
        //n为1时，表明后面的节点不需要反转，直接返回当前节点，并且记录后续节点
        if (n == 1) {
            backNode = head.next;
            return head;
        }
        //递归，返回最后面的那个节点
        ListNode last = reverseN(head.next, n - 1);
        //反转，头节点加到尾部
        head.next.next = head;
        //反转后的头节点的下一个节点为之前存储的后继节点
        head.next = backNode;
        return last;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode res = reverseBetween(node1, 2, 5);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
