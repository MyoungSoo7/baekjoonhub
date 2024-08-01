
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // 최대 힙을 구현하기 위해 PriorityQueue를 역순으로 설정
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();

            if (x > 0) {
                maxHeap.add(x);
            } else {
                if (maxHeap.isEmpty()) {
                    output.append(0).append('\n');
                } else {
                    output.append(maxHeap.poll()).append('\n');
                }
            }
        }

        // 결과 한 번에 출력
        System.out.print(output.toString());

        scanner.close();
    }
}
