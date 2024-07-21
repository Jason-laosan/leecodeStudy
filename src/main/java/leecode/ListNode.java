package leecode;

public class ListNode {
    int value;
    ListNode next;

    public ListNode(int x) {
        value = x;
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length <= 0) {
            throw new IllegalArgumentException("array param is not null");
        }
        this.value = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.value).append("->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
