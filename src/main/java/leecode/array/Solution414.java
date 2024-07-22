package leecode.array;

public class Solution414 {

    public static int thirdMax(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x > a) {
                c = b;
                b = a;
                a = x;
            } else if (x < a && x > b) {
                c = b;
                b = x;
            } else if (x < b && x > c) {
                //若 b>num>c，类似地，我们将 c 替换为 num，a 和 b 保持不变；
                c = x;
            }
        }
        //若 b>num>c，类似地，我们将 c 替换为 num，a 和 b 保持不变；
        return c == Long.MIN_VALUE ? (int) a : (int) c;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(thirdMax(arr));
    }
}
