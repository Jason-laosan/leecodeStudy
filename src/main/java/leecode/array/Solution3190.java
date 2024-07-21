package leecode.array;

public class Solution3190 {
    /**
     * 给你一个整数数组 nums 。一次操作中，你可以将 nums 中的 任意 一个元素增加或者减少 1 。
     * <p>
     * 请你返回将 nums 中所有元素都可以被 3 整除的 最少 操作次数。
     *
     * @param nums
     * @return
     */
    public int minimumOperations(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 != 0) {
               res++;
            }
        }
        return res;
    }
}
