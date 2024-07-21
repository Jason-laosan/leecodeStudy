package leecode.array;

public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        return doubleFlag(nums);
    }

    private static int doubleFlag1(int[] nums) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        return  Math.max(res, count);
    }

    private static int doubleFlag(int[] nums) {
        int max = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] == 1) {
                r++;
                max = Math.max(max, r - l);
            } else {
                r++;
                l = r;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = {1, 0, 1, 1, 1, 1, 1};

        System.out.println(new Solution485().findMaxConsecutiveOnes(ints));
    }
}
