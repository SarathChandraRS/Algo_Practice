package Recursion;

public class ReverseLinkedList {
    static class ListNode{
        ListNode next;int val;
    }

    public static void main(String args[]){

    }

    public ListNode reverst(ListNode head){
        if(head.next == null || head == null){
            return head;
        }
        ListNode p = reverst(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
