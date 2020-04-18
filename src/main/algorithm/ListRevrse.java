package main.algorithm;

/**
 * @author ZhangYun
 * @version 1.0
 * @date 2020/4/17
 */
public class ListRevrse {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Node resNode = solution(node1);
        while(resNode != null){
            System.out.println(resNode.val + " ");
            resNode = resNode.next;
        }
    }

    private static Node solution(Node head) {
        if(head == null || head.next == null)   return head;

        //递归
        Node tail = solution(head.next);

        //翻转最后一个head
        head.next.next = head;

        //当前的头指向null
        head.next = null;

        return tail;

    }
}
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}
