package main.algorithm.lc_list;

import java.util.StringTokenizer;

public class ReverseKGroup_25 {

    private ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
    
        ListNode pre = dummy;
        ListNode end = dummy;
    
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
    
            end = pre;
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
    
    public static void main(String[] args) {
        ReverseKGroup_25 leetcode_25 = new ReverseKGroup_25();
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
        ListNode node = leetcode_25.reverseKGroup(node1, 3);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("————————————");
        StringTokenizer stringTokenizer = new StringTokenizer("a[index]=4+2", "[");
        System.out.println(stringTokenizer.nextToken());
        String s = "a[index]=4+2";
        
        String[] strs = s.split("");
        for(String str : strs){
            System.out.println(str);
        }
    }
}