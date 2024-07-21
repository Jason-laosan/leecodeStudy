package leecode;

public class Solution203Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,6,5,6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        Solution203 s = new Solution203();
        ListNode v = s.removeElementsByRecursion(listNode, 6);
        System.out.println(v);
    }
}
