package main.algorithm.lc_list;

/**
 * 删除链表的倒数第n个节点
 */
public class DelNthFromEnd_19 {

    private ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre , end = pre;
        while(n!=0){
            start = start.next;
            n--;
        }
        while(start.next!=null){
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        DelNthFromEnd_19 leetcode_19 = new DelNthFromEnd_19();
        ListNode node = leetcode_19.removeNthFromEnd(head, 2);
        System.out.print(node.val+" ");
        while((node = node.next)!=null){
            System.out.print(node.val+" ");
        }
        System.out.println();
    }
}
