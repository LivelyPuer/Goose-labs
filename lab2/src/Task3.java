import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 1; i <= 10000; i+=500) {
            int[] arr = new int[i];
            for (int j = 0; j < i; j++) {
                arr[j] = rand.nextInt(1000);
            }
            long startTimeN1 = System.currentTimeMillis();
            Task3.sort(arr);
            long timeN1 = System.currentTimeMillis() - startTimeN1;

            long startTimeN2 = System.currentTimeMillis();
            Task3.prefixSum(arr);
            long timeN2 = System.currentTimeMillis() - startTimeN2;

            long startTimeN3 = System.currentTimeMillis();
            Task3.quickSort(arr);
            long timeN3 = System.currentTimeMillis() - startTimeN3;

            System.out.println(i + ";" + timeN1 + ";" + timeN2 + ";" + timeN3);
        }
    }

    /*
     * Сортировка пузырьком n^2*/
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /*
     * Префиксная сумма n*/
    public static int prefixSum(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum[n - 1];
    }

    /*
     * Быстрая сортировка n log n*/
    public static void quickSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        int pivot = arr[0];
        int[] left = new int[n - 1];
        int[] right = new int[n - 1];
        int i = 0, j = 0;
        for (int k = 1; k < n; k++) {
            if (arr[k] < pivot) {
                left[i++] = arr[k];
            } else {
                right[j++] = arr[k];
            }
        }
        left[i] = pivot;
        right[j - 1] = pivot;
        i = 0;
        j = 0;
        for (int k = 0; k < n; k++) {
            if (k % 2 == 0) {
                arr[k] = left[i++];
            } else {
                arr[k] = right[j++];
            }
        }
        sort(left);
        sort(right);
    }
}