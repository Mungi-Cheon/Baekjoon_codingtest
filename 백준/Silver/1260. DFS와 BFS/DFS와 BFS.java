import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main{
    void dfs(Map<Integer, List<Integer>> graph, int V) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        stack.push(V);

        while (!stack.isEmpty()) {
            int curEdge = stack.pop();

            if (!visited.containsKey(curEdge)) {
                sb.append(curEdge).append(" ");
                visited.put(curEdge, true);
            }

            List<Integer> nextEdges = graph.get(curEdge);
            for (int i = nextEdges.size() - 1; i >= 0; i--) {
                if (!visited.containsKey(nextEdges.get(i))) {
                    stack.push(nextEdges.get(i));
                }
            }
        }

        if (sb.length() != 0) {
            sb.setLength(sb.length() - 1);
            System.out.println(sb);
        }
    }

    void bfs(Map<Integer, List<Integer>> graph, int V) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        queue.offer(V);
        visited.put(V, true);

        while (!queue.isEmpty()) {
            int curEdge = queue.poll();
            sb.append(curEdge).append(" ");

            List<Integer> nextEdges = graph.get(curEdge);
            for (Integer next : nextEdges) {
                if (!visited.containsKey(next)) {
                    queue.offer(next);
                    visited.put(next, true);
                }
            }
        }

        if (sb.length() != 0) {
            sb.setLength(sb.length() - 1);
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        Main app = new Main();
        app.dfs(graph, V);
        app.bfs(graph, V);
    }
}