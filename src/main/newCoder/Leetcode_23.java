package main.newCoder;

import main.newCoder.ListNode;

/**
 * 合并k个有序链表
 */
public class Leetcode_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergekLists(lists, 0, lists.length - 1);
    }

    public ListNode mergekLists(ListNode[] lists, int i, int j) {
        if(i==j){
            return lists[i];
        }else{
            int mid = (i+j)/2;
            ListNode l1 = mergekLists(lists,i,mid);
            ListNode l2 = mergekLists(lists,mid+1,j);
            ListNode res = mergeTwoLists(l1, l2);
            return res;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                while (node1.next != null && node1.next.val <= node2.val) {
                    node1 = node1.next;
                }
                ListNode mid = node1;
                node1 = node1.next;
                mid.next = node2;
                // node2 = node2.next;
            } else {
                while (node2.next != null && node2.next.val <= node1.val) {
                    node2 = node2.next;
                }
                ListNode mid = node2;
                node2 = node2.next;
                mid.next = node1;
                // node1 = node1.next;
            }
        }
        if (l1.val <= l2.val) {
            return l1;
        } else
            return l2;
    }

    public static void main(String[] args) {
        Leetcode_23 leetcode_23 = new Leetcode_23();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(0);
        ListNode node8 = new ListNode(6);
        // node1.next = node2;
        // node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        // node7.next = node8;
        ListNode[] nodes = { node1,  node7 };
        ListNode node = leetcode_23.mergeKLists(nodes);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("");
    }
}