import java.util.Arrays;

class Bubble {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

class Task4 {
    public static void main(String[] args) {
        for (int i = 1000; i <= 10000; i += 1000) {
            int[] x = new int[i];
            int[] y = new int[i];
            for (int j = 0; j < x.length; j++) {
                x[j] = (int) (Math.random() * 10000);
                y[j] = (int) (Math.random() * 10000);
            }
            long start = System.currentTimeMillis();
            Bubble.bubbleSort(x);
            long end = System.currentTimeMillis();

            long start_y = System.currentTimeMillis();
            Arrays.parallelSort(x);
            long end_y = System.currentTimeMillis();
            System.out.println(x.length + " " + (end - start) + " " + (end_y - start_y));

        }
    }
}
