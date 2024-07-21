package practice;

public class Sum {
    public static int sum(int[] arr) {
        return sumRecursion(arr, 0);
//        return sumRecursion2(arr, arr.length - 1);
//        return sumFor(arr);
    }

    public static int sumFor(int[] arr) {
        int count = 0;
        for (int i : arr) {
            count += i;
        }
        return count;
    }

    public static int sumRecursion(int[] arr, int index) {
        if (index == arr.length) return 0;
        return arr[index] + sumRecursion(arr, index + 1);
    }

    public static int sumRecursion2(int[] arr, int index) {
        if (index < 0) return 0;
        return arr[index] + sumRecursion(arr, index - 1);
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 5, 6, 7};
        System.out.println(sum(arr));
    }
}
