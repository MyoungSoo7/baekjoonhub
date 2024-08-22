import java.util.*;
class Solution {
    // 지도에서 각 방향으로 이동하기 위한 배열
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    public static List<Integer> solution(String[] maps) {
        int rows = maps.length;
        int cols = maps[0].length();
        boolean[][] visited = new boolean[rows][cols];
        List<Integer> islandDays = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    // 새로운 섬을 발견했을 때 BFS로 탐색
                    int days = bfs(maps, visited, i, j);
                    islandDays.add(days);
                }
            }
        }

        if (islandDays.isEmpty()) {
            islandDays.add(-1);
        } else {
            Collections.sort(islandDays);
        }

        return islandDays;
    }

    private static int bfs(String[] maps, boolean[][] visited, int startX, int startY) {
        int rows = maps.length;
        int cols = maps[0].length();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        int totalDays = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            totalDays += maps[x].charAt(y) - '0'; // 현재 위치의 식량을 더함

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return totalDays;
    }
}