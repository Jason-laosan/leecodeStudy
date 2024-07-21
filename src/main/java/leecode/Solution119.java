package leecode;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    //杨辉三角
    //给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
    //在杨辉三角中，每个数是它左上方和右上方的数的和。
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res.add(0);
            for (int j = i; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution119().getRow(3));
    }
}
