import java.util.Arrays;
import java.util.Random;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        boolean user = true;
        if (user) {

            int N = 5;
            int S = 0;
            int[][] matrix = {
                    {0, 150, 1000000, 4, 5},
                    {150, 0, 10, 3, 5},
                    {1000000, 10, 0, 2, 5},
                    {4, 3, 5, 0, 9},
                    {5, 5, 5, 9, 0}};
            int[] res = Dijkstra(N, S, matrix);
            System.out.println("\n" + Arrays.toString(res));
        } else {
            Random random = new Random();
            for (int N = 500; N < 20000; N += 2000) {
                int S = 0;
                int[][] matrix = new int[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (i != j) {
                            matrix[i][j] = random.nextInt(10);
                        }
                    }
                }
                long startTime = System.currentTimeMillis();
                int[] res = Dijkstra(N, S, matrix);
                long endTime = System.currentTimeMillis();
                System.out.println(N + ";" + (endTime - startTime));
            }
        }
    }

    public static int[] Dijkstra(int N, int S, int[][] matrix) {
        boolean[] valid = new boolean[N];
        Arrays.fill(valid, true);
        int[] weight = new int[N];
        Arrays.fill(weight, 1000000);
        weight[S] = 0;
        for (int i = 0; i < N; i++) {
            int minWeight = 1000001;
            int idMinWeight = -1;
            for (int j = 0; j < N; j++) {
                if (valid[j] && weight[j] < minWeight) {
                    minWeight = weight[j];
                    idMinWeight = j;
                }
            }
            for (int z = 0; z < N; z++) {
                if (weight[idMinWeight] + matrix[idMinWeight][z] < weight[z]) {
                    weight[z] = weight[idMinWeight] + matrix[idMinWeight][z];
                }
            }
            valid[idMinWeight] = false;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return weight;
    }
}
