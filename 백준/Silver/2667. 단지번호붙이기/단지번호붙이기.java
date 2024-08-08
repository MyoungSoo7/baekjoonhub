
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n; // 지도의 크기
    static int[][] map; // 지도
    static boolean[][] visited; // 방문 여부
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        // 지도 입력
        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> complexSizes = new ArrayList<>();

        // 모든 지점을 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    // 새로운 단지를 발견하면 DFS 수행
                    int size = dfs(i, j);
                    complexSizes.add(size);
                }
            }
        }

        // 단지 수 출력
        System.out.println(complexSizes.size());

        // 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력
        Collections.sort(complexSizes);
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    // 깊이 우선 탐색
    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1; // 현재 집 포함

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도 범위를 벗어나지 않고, 집이 있으며, 방문하지 않은 경우
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    count += dfs(nx, ny);
                }
            }
        }

        return count;
    }

}
