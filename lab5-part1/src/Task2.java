import java.util.Arrays;

class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}

class Test2 {
    public static void main(String[] args) {
        for (int i = 1000; i < 100000000; i += 10000000) {
            int[] x = new int[i];
            for (int j = 0; j < x.length; j++) {
                x[j] = (int) (Math.random() * i);
            }
            long start = System.currentTimeMillis();
            BinarySearch.binarySearch(x, i / 2);
            long end = System.currentTimeMillis();

            long start_y = System.currentTimeMillis();
            Arrays.binarySearch(x, i / 2);
            long end_y = System.currentTimeMillis();
            System.out.println(x.length + " " + (end - start) + " " + (end_y - start_y));
        }
    }
}
// hashtable
// stack
// heap
