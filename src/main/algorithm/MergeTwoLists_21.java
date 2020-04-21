package main.algorithm;

/**
 * 合并两个有序链表
 */
public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
                //node2 = node2.next;
            } else {
                while (node2.next != null && node2.next.val <= node1.val) {
                    node2 = node2.next;
                }
                ListNode mid = node2;
                node2 = node2.next;
                mid.next = node1;
                //node1 = node1.next;
            }
        }
        if (l1.val <= l2.val) {
            return l1;
        } else
            return l1;
    }

    public static void main(String[] args) {
        MergeTwoLists_21 leetcode_21 = new MergeTwoLists_21();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        ListNode node = leetcode_21.mergeTwoLists(node1, node4);
        while(node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println("");
    }

}