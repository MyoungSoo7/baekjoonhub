import java.util.PriorityQueue;

public class Solution {
    public int solution(int n, int k, int[] enemy) {
        // 최대 힙을 사용하여 무적권을 사용할 라운드를 결정
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int rounds = 0;

        for (int i = 0; i < enemy.length; i++) {
            // 현재 라운드의 적 수를 최대 힙에 추가
            maxHeap.add(enemy[i]);
            n -= enemy[i]; // 병사를 사용하여 적을 막음

            // 병사가 부족한 경우
            if (n < 0) {
                // 무적권을 사용할 수 있는 경우
                if (k > 0) {
                    n += maxHeap.poll(); // 가장 많은 적이 등장한 라운드에 무적권 사용
                    k--; // 무적권 사용 횟수 감소
                } else {
                    // 무적권도 없고 병사도 부족하면 게임 종료
                    break;
                }
            }
            rounds++; // 막은 라운드 수 증가
        }

        return rounds;
    }

    
}
