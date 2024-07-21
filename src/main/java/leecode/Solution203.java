package leecode;


public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head != null && head.value == val) {
            head = head.next;
//            ListNode del = head;
//            head = del.next;
//            del.next = null;
        }
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.value == val) {
//                ListNode del = pre.next;
//                pre.next = del.next;
//                del.next = null;
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

    public ListNode removeElementsByDummyHead(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.value == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElementsByRecursion(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode res = removeElementsByRecursion(head.next, val);
        if (head.value == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }

//        head.next = removeElementsByRecursion(head.next, val);
//        return head.value == val ? head.next : head;
    }
}

