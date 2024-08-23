import java.util.LinkedList;
import java.util.Queue;
class Solution {
   static class Point {
        int x, y, moves;

        Point(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    public static int solution(String[] board) {
        int rows = board.length;
        int cols = board[0].length();
        boolean[][] visited = new boolean[rows][cols];
        Queue<Point> queue = new LinkedList<>();

        int startX = 0, startY = 0;
        int goalX = 0, goalY = 0;

        // Find the start (R) and goal (G) positions
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                } else if (board[i].charAt(j) == 'G') {
                    goalX = i;
                    goalY = j;
                }
            }
        }

        // Directions: up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Start BFS from the robot's initial position
        queue.add(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // Check if we've reached the goal
            if (current.x == goalX && current.y == goalY) {
                return current.moves;
            }

            // Explore all four directions
            for (int d = 0; d < 4; d++) {
                int nx = current.x;
                int ny = current.y;

                // Move in the current direction until hitting a wall or obstacle
                while (true) {
                    int nextX = nx + dx[d];
                    int nextY = ny + dy[d];

                    if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || board[nextX].charAt(nextY) == 'D') {
                        break;
                    }

                    nx = nextX;
                    ny = nextY;
                }

                // If the new position is not visited, add it to the queue
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, current.moves + 1));
                }
            }
        }

        // If the goal is not reachable, return -1
        return -1;
    }
}