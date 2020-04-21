package main.algorithm.lc_list;

import main.algorithm.lc_list.ListNode;

public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if(k == 0) return head;
        int num = 0;//Node's number
        ListNode temp = head;//计数，并且存储原链表的末尾节点
        while (temp.next != null) {
            num++;
            temp = temp.next;
        }
        int Step = k % (num + 1);
        if(Step == 0) return head;
        temp.next = head;//成环
        int rStep = num + 1 - Step;
        ListNode pre = head;
        ListNode res = head.next;
        //res移动rStep - 1步到旋转后的头节点，pre是旋转后的末尾
        for (int i = 1; i < rStep; i++) {
            pre = pre.next;
            res = res.next;
        }
        pre.next = null;//断链
        return res;

    }
}
