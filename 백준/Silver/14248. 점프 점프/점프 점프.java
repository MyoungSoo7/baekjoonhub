 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 돌다리의 돌 개수 n 입력
        int n = scanner.nextInt();
        int[] stones = new int[n + 1]; // 1-based index 사용

        // 각 돌에서 점프할 수 있는 거리 Ai 입력
        for (int i = 1; i <= n; i++) {
            stones[i] = scanner.nextInt();
        }

        // 출발점 s 입력
        int s = scanner.nextInt();

        // 방문 여부를 체크할 배열
        boolean[] visited = new boolean[n + 1];

        // BFS를 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        int count = 0; // 방문 가능한 돌의 개수

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            // 왼쪽으로 점프
            int left = current - stones[current];
            if (left >= 1 && !visited[left]) {
                visited[left] = true;
                queue.add(left);
            }

            // 오른쪽으로 점프
            int right = current + stones[current];
            if (right <= n && !visited[right]) {
                visited[right] = true;
                queue.add(right);
            }
        }

        // 결과 출력
        System.out.println(count);

        scanner.close();
    }
}
