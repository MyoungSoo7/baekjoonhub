class Solution {
     public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    public int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        // 현재 숫자를 더하는 경우
        int countWithAddition = dfs(numbers, target, index + 1, sum + numbers[index]);
        
        // 현재 숫자를 빼는 경우
        int countWithSubtraction = dfs(numbers, target, index + 1, sum - numbers[index]);
        
        // 두 경우의 수를 합산
        return countWithAddition + countWithSubtraction;
    }
    
   
}