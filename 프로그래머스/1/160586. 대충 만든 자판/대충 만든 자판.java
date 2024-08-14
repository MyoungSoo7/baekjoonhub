import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];

        // 각 문자가 입력되기 위해 필요한 최소 키 입력 횟수를 저장하는 맵
        Map<Character, Integer> charToMinPress = new HashMap<>();

        // keymap을 순회하며 각 문자가 입력되기 위한 최소 키 입력 횟수를 계산
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                int pressCount = i + 1; // i번째 위치에 있으므로 i+1번 눌러야 함
                charToMinPress.put(c, Math.min(charToMinPress.getOrDefault(c, Integer.MAX_VALUE), pressCount));
            }
        }

        // 각 target 문자열에 대해 최소 키 입력 횟수를 계산
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int totalPressCount = 0;
            boolean isPossible = true;

            for (char c : target.toCharArray()) {
                if (charToMinPress.containsKey(c)) {
                    totalPressCount += charToMinPress.get(c);
                } else {
                    isPossible = false;
                    break;
                }
            }

            result[i] = isPossible ? totalPressCount : -1;
        }

        return result;
    }
}