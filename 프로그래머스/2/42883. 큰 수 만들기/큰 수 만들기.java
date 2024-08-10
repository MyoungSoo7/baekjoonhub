class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int length = number.length() - k;
        char[] numArray = number.toCharArray();

        int start =0;
        for(int i=0; i<length; i++){
            char max = '0';
            for(int j = start; j <= i+k; j++){
                if(numArray[j] > max){
                    max = numArray[j];
                    start = j+1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}