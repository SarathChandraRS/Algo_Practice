package linkedlist;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (slowPointer != null && fastPointer != null) {

            slowPointer = slowPointer.next;
            if (fastPointer.next != null) {
                fastPointer = fastPointer.next.next;
            } else {
                return false;
            }
            if (slowPointer != null && fastPointer != null && slowPointer == fastPointer) {
                return true;
            }
        }
        return false;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
