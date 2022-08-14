package Recursion;

import java.util.List;

public class MergeTwoLists {

    public ReverseLinkedList.ListNode sortedMergeLists(ReverseLinkedList.ListNode a, ReverseLinkedList.ListNode b){
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }

        if(a.val < b.val){
            a.next = sortedMergeLists(a.next,b);
            return a;
        }else {
            b.next = sortedMergeLists(a,b.next);
            return b;
        }
    }
}
