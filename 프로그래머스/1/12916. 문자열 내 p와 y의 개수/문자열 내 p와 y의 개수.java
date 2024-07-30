class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String lowerString = s.toLowerCase();
        int pCount = 0;
        int yCount = 0;

        for(int i=0; i<lowerString.length(); i++) {
            if(lowerString.charAt(i) == 'p') {
                pCount++;
            } else if(lowerString.charAt(i) == 'y') {
                yCount++;
            }
        }
        if(pCount != yCount) {
            answer = false;
        }

        return answer;
    }
}