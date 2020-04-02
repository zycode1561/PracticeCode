package main.algorithm;

public class Solution1 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        int c = 0;//进位
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val;
            if(sum + c >= 10){
                head.next = new ListNode(sum - 10 + c);
                c = 1;
            }else{
                head.next = new ListNode(sum + c);
                c = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }
        while(l1 != null){
            if(l1.val + c >= 10){
                head.next = new ListNode(l1.val - 10 + c);
                c = 1;
            }else{
                head.next = new ListNode(l1.val + c);
                c = 0;
            }
            l1 = l1.next;
            head = head.next;
        }
        while(l2 != null){
            if(l2.val + c >= 10){
                head.next = new ListNode(l2.val - 10 + c);
                c = 1;
            }else{
                head.next = new ListNode(l2.val + c);
                c = 0;
            }
            l2 = l2.next;
            head = head.next;
        }
        if(c == 1){
            head.next = new ListNode(1);
        }
        return pre.next;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode res = addTwoNumbers(l1,l2);
        while(res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
