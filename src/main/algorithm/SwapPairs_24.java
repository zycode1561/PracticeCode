package main.algorithm;

/**
 * 两两交换链表中的节点
 */
public class SwapPairs_24 {

    private ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode pre = new ListNode(-1);
        ListNode node1 = pre;
        pre.next = head;
        ListNode node2 = head;
        ListNode node3 = head.next;
        while (node1 != null && node2 != null && node3 != null) {
            node2.next = node3.next;
            node3.next = node2;
            node1.next = node3;
            node1 = node1.next.next;
            node2 = node2.next;
            if (node3.next.next == null) {
                break;
            } else {
                node3 = node3.next.next.next;
            }
        }
        return pre.next;
    }


    public static void main(String[] args) {
        SwapPairs_24 leetcode_24 = new SwapPairs_24();
        ListNode node0 = null;
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
        ListNode node = leetcode_24.swapPairs(node1);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("");
    }
}