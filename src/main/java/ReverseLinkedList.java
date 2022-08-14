import java.util.LinkedList;

public class ReverseLinkedList {
    static class ListNode{
        ListNode next;int val;
    }
    public ListNode reverse (ListNode head){
        ListNode prev = null ;
        while(head !=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
