import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int n = numbers.length;
        Stack<Integer> stack = new Stack<>();
        

        for(int i=0; i< n-1 ; i++){
            stack.push(i);
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i+1]){
                answer[stack.pop()] = numbers[i+1];
            }
        }
        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }
         answer[numbers.length-1]=-1;
     
        return answer;
    }
}