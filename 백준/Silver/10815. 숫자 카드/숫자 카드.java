import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 상근이가 가지고 있는 숫자 카드의 개수 N 입력
        int N = scanner.nextInt();
        Set<Integer> cardSet = new HashSet<>();

        // 상근이가 가지고 있는 숫자 카드 입력
        for (int i = 0; i < N; i++) {
            cardSet.add(scanner.nextInt());
        }

        // 확인해야 할 숫자 카드의 개수 M 입력
        int M = scanner.nextInt();
        int[] checkCards = new int[M];

        // 확인해야 할 숫자 카드 입력
        for (int i = 0; i < M; i++) {
            checkCards[i] = scanner.nextInt();
        }

        // 각 숫자 카드가 상근이가 가지고 있는 카드인지 여부를 출력
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (cardSet.contains(checkCards[i])) {
                result.append("1 ");
            } else {
                result.append("0 ");
            }
        }

        // 결과 출력
        System.out.println(result.toString().trim());

        scanner.close();
    }
}