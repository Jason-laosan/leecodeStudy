package leecode.array;

public class Solution495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int expired = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            //未中毒 则相加
            if (timeSeries[i] >= expired) {
                res += duration;
            } else {
                //中毒情况下，不能叠加
                res += timeSeries[i] + duration - expired;
            }
            //下次中毒结束时间
            expired = timeSeries[i] + duration;
        }
        return res;
    }
}
