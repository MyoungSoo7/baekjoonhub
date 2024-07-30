import java.util.HashMap;
import java.util.Map;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer,Integer> poketmonMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(poketmonMap.getOrDefault(nums[i],0) == 0) {
                poketmonMap.put(nums[i], 1);
            }
        }
        for(Integer poketmon : poketmonMap.keySet()) {
            answer++;
            if(answer == nums.length/2) {
                return answer;
            }
        }
        return answer;
    }
}