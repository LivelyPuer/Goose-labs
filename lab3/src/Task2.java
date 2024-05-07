import java.util.*;

public class Task2 {

    public static void main(String[] args) {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(3, 2),
                Arrays.asList(3),
                Arrays.asList()
        );
        List<Integer> result = Task2.bfs(graph, 0);
        System.out.println(result);
    }

    public static List<Integer> bfs(List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.remove();

            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return new ArrayList<>(visited);
    }

}
