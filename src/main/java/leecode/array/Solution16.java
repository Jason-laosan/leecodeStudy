package leecode.array;

import java.util.Arrays;

public class Solution16 {
    public int threeSumCloset(int[] nums, int target) {
        int result = 100000;
        Arrays.sort(nums);
        int n = nums.length;
        for (int a = 0; a < n; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int b = a + 1;
            int c = n - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                while (b > a + 1 && nums[b] == nums[b - 1] && b < c) {
                    b++;
                }
                while (c < n - 1 && nums[c] == nums[c - 1] && b < c) {
                    c--;
                }

                if (target == sum) {
                    return target;
                } else if (target > sum) {
                    result = Math.abs(target - sum) > Math.abs(target - result) ? result : sum;
                    b++;
                } else {
                    result = Math.abs(target - sum) > Math.abs(target - result) ? result : sum;
                    c--;
                }


//                if (sum == target) {
//                    return target;
//                }
//                if (Math.abs(sum - target) < Math.abs(result - target)) {
//                    result = sum;
//                }
//                if (sum > target) {
//                    // 如果和大于 target，移动 c 对应的指针
//                    int k0 = c - 1;
//                    // 移动到下一个不相等的元素
//                    while (b < k0 && nums[k0] == nums[c]) {
//                        --k0;
//                    }
//                    c = k0;
//                } else {
//                    // 如果和小于 target，移动 b 对应的指针
//                    int j0 = b + 1;
//                    // 移动到下一个不相等的元素
//                    while (j0 < c && nums[j0] == nums[b]) {
//                        ++j0;
//                    }
//                    b = j0;
//                }


            }
        }
        return result;
    }
}
