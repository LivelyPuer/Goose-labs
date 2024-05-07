import java.util.Random;
import java.util.Scanner;

/*
Задача о порядке перемножения матриц — классическая задача динамического программирования,
в которой дана последовательность матриц.  и требуется минимизировать количество скалярных операций
для вычисления их произведения. Матрицы предполагаются совместимыми по отношению к матричному умножению
(то есть количество столбцов Ai-1 совпадает с количеством строк Ai

n^3

*/

public class Task2 {
    /*
     * Возвращает ответ на задачу об оптимальном перемножении матриц, используя
     * динамическое программирование.
     * Асимптотика решения - O(N^3) время.
     */
    public static int multiplyOrder(int[] p) {
        int n = p.length - 1;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = 0;
        }

        for (int l = 1; l < n; ++l) {
            for (int i = 0; i < n - l; ++i) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    int g = dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    dp[i][j] = Math.min(dp[i][j], g);
                }
            }
        }
        return dp[0][n - 1];
    }
    public static void main(String[] args) {
        int[] test = { 10, 100, 50, 5 , 3};
        System.out.println(multiplyOrder(test));
    }
//    public static void main(String[] args) {
//        boolean userInput = false;
//        if (!userInput) {
//            Random rand = new Random();
//            for (int i = 10; i < 1000; i+=100) {
//                int m = i;
//                int[] p = new int[m];
//                for (int j = 0; j < m; j++) {
//                    p[j] = rand.nextInt(100);
//                }
//                long time = System.currentTimeMillis();
//                multiplyOrder(p);
//                System.out.println(i + ";" + (System.currentTimeMillis() - time));
//            }
//        } else {
//            System.out.println("Введите кол-во матриц");
//            Scanner scanner = new Scanner(System.in);
//            int n = scanner.nextInt();
//            int[] p = new int[n];
//            System.out.println("Введите массив размеров матриц");
//            for (int i = 0; i < n; i++) {
//                p[i] = scanner.nextInt();
//            }
//            System.out.println(multiplyOrder(p));
//        }
//
//    }
}
