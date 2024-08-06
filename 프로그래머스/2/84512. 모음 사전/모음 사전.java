class Solution {
    public int solution(String word) {
         int[] weights = {781, 156, 31, 6, 1}; // 각 자리의 가중치
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        int result = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            for (int j = 0; j < vowels.length; j++) {
                if (c == vowels[j]) {
                    result += j * weights[i] + 1;
                    break;
                }
            }
        }

        return result;
    }
}