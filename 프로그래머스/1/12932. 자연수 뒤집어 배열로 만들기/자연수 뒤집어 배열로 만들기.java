class Solution {
    public int[] solution(long n) {
          String str = String.valueOf(n);
        int[] answer = new int[str.length()];
        int cnt =0;
        for(int i = str.length()-1; i >= 0; i--){
            answer[cnt] = Integer.parseInt(String.valueOf(str.charAt(i)));
            cnt++;
        }

        return answer;
    }
}