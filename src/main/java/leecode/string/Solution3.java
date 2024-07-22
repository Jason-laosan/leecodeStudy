package leecode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    /**
     * abcabcbb
     * a abc
     *  bc ab
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //滑窗算法
        char[] ca = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int res = 0;
        int r = 0;
        for (int i = 0; i < ca.length; i++) {
            if (i != 0) {
                set.remove(ca[i - 1]);
            }
            while (r < ca.length && !set.contains(ca[r])) {
                set.add(ca[r]);
                r++;
            }
            res = Math.max(res, r - i);
        }
        return res;
    }
}
