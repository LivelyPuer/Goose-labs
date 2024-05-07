import java.util.Arrays;

class QuickSort {

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
    public static void main(String[] args) {
        int[] x = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
        System.out.println("Было");
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        quickSort(x, low, high);
        System.out.println("Стало");
        System.out.println(Arrays.toString(x));
    }
}

class Task1 {
    public static void main(String[] args) {
        for (int i = 1000; i < 1000000; i+=100000){
            int[] x = new int[i];
            int[] y = new int[i];
            for (int j = 0; j < x.length; j++){
                x[j] = (int) (Math.random() * 10000);
                y[j] = (int) (Math.random() * 10000);
            }
            int low = 0;
            int high = x.length - 1;
            long start = System.currentTimeMillis();
            QuickSort.quickSort(x, low, high);
            long end = System.currentTimeMillis();

            long start_y = System.currentTimeMillis();
            Arrays.sort(x, low, high);
            long end_y = System.currentTimeMillis();
            System.out.println(x.length + " " + (end - start) + " " + (end_y - start_y));
        }
    }
}