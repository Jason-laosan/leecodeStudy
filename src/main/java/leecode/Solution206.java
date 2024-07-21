package leecode;

public class Solution206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        for (int i = 0; i < 5; i++) {
            ListNode cur = new ListNode(i);
            cur.next = head.next;
            head.next = cur;
        }
        System.out.println(head);
//        System.out.println(convert(head));
        ListNode data = convertRecursion(head);
        System.out.println(data);
    }

    public static ListNode convert(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * TODO 未理解
     * @param head
     * @return
     */
    public static ListNode convertRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode revNode = convertRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return revNode;
    }

}
