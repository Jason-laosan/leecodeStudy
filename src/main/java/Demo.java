import java.util.Arrays;

public class Demo {

    /**
     * 数字  三个数字 和 接近 给定数
     * 返回三个数字
     * 1 3 5 6 3 2 4
     * 1 3 5 - target = x
     * 1  3 6 -target = x
     * 1 3 3
     * 1 3 2
     * sort;
     * 123452
     * target- a;
     * target;
     *
     * @param data
     * @param target
     * @return
     */
    public int[] nearlyAddTarget(int[] data, int target) {
//        Arrays.sort(data);
        int a1 = 0, b1 = 1, c1 = 2;
        int nearly = data[a1] + data[b1] + data[c1] - target > 0 ? data[a1] + data[b1] + data[c1] - target : target - data[a1] + data[b1] + data[c1];
        for (int i = 0; i < data.length - 2; i++) {
            for (int j = i + 1; j < data.length - 1; j++) {
                for (int k = j + 1; k < data.length; k++) {
                    int temp = data[i] + data[j] + data[k] - target > 0 ? data[i] + data[j] + data[k] - target : target - data[i] + data[j] + data[k];
                    if (temp <= nearly) {
                        a1 = i;
                        b1 = j;
                        c1 = k;
                        nearly = temp;
                    }
                }
            }
        }
        return new int[]{data[a1], data[b1], data[c1]};
    }

    public static void main(String[] args) {

    }

}
