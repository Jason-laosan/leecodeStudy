package leecode.array;

public class Solution26 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new Solution26().removeDuplicates(nums));
    }


    public int removeDuplicates(int[] nums) {
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[pre]) {
                pre++;
                nums[pre] = nums[i];
            }
        }
        return pre + 1;
    }

}
