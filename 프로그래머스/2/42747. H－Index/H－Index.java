import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
         // Step 1: 배열을 내림차순으로 정렬
        Arrays.sort(citations);
        int n = citations.length;
        
        // Step 2: H-Index를 찾기
        for (int i = 0; i < n; i++) {
            // 인용 횟수가 논문의 순서보다 크거나 같은 경우의 최대 값을 찾음
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        
        // 모든 논문이 h번 이하로 인용된 경우 0을 반환
      
        return answer;
    }
}