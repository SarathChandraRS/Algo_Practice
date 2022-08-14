public class MergeLinkedLists {
    static class ListNode{
        MergeLinkedLists.ListNode next;int val;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                head.next = list1;
                list1 = list1.next;
            }else{
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        if(list1 != null){
            head.next = list1;
        }
        if(list2 != null){
            head.next = list2;
        }
        return temp.next;
    }


    public ListNode recursiveSortedList(ListNode A, ListNode B){
        if( A== null){
            return B;
        }
        if( B== null){
            return A;
        }

        if(A.val < B.val){
            A.next = recursiveSortedList(A.next,B);
            return A;
        }
        else{
            B.next = recursiveSortedList(A,B.next);
            return B;
        }
    }
}
