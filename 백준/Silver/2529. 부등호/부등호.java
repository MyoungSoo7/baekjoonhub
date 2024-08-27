 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int k;
    static char[] signs;
    static boolean[] used = new boolean[10];
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 부등호의 개수 입력
        k = scanner.nextInt();
        signs = new char[k];

        // 부등호 입력
        for (int i = 0; i < k; i++) {
            signs[i] = scanner.next().charAt(0);
        }

        // 백트래킹 시작
        backtrack("", 0);

        // 결과 정렬
        results.sort(null);

        // 최솟값과 최댓값 출력
        System.out.println(results.get(results.size() - 1) + "\n" + results.get(0) );

        scanner.close();
    }

    // 백트래킹 함수
    static void backtrack(String num, int depth) {
        if (depth == k + 1) {
            if (isValid(num)) {
                results.add(num);
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(num + i, depth + 1);
                used[i] = false;
            }
        }
    }

    // 부등호 조건을 만족하는지 확인하는 함수
    static boolean isValid(String num) {
        for (int i = 0; i < k; i++) {
            if (signs[i] == '<' && num.charAt(i) >= num.charAt(i + 1)) {
                return false;
            }
            if (signs[i] == '>' && num.charAt(i) <= num.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
