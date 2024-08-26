import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public int solution(int n, int[][] wires) {
        // 그래프 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        int minDifference = n;
        
        // 각 간선을 하나씩 제거하고 나누어진 트리의 크기를 계산
        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];
            
            // 간선 제거
            graph.get(node1).remove((Integer) node2);
            graph.get(node2).remove((Integer) node1);
            
            // 두 부분 트리의 크기 계산
            int size1 = bfs(graph, n, node1);
            int size2 = n - size1;
            int difference = Math.abs(size1 - size2);
            
            // 최솟값 갱신
            if (difference < minDifference) {
                minDifference = difference;
            }
            
            // 간선 복원
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        
        return minDifference;
    }
    
    private int bfs(List<List<Integer>> graph, int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        
        return count;
    }
}
