class Solution {
    public long solution(int n) {
        // n이 1 또는 2일 경우, 방법의 수는 n과 같습니다.
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 동적 프로그래밍을 위한 배열 선언
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        // 점화식을 이용하여 방법의 수 계산
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        // n칸에 도달하는 방법의 수 반환
        return dp[n];
    }
}