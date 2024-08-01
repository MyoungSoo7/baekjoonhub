import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String solution(int[] numbers) {
       // int 배열을 String 배열로 변환
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 커스텀 Comparator를 사용하여 정렬
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 두 문자열을 이어 붙였을 때 더 큰 값을 만드는 순서로 정렬
                String order1 = o1 + o2;
                String order2 = o2 + o1;
                return order2.compareTo(order1); // 내림차순 정렬
            }
        });

        // 정렬된 배열을 하나의 문자열로 합침
        StringBuilder result = new StringBuilder();
        for (String str : strNumbers) {
            result.append(str);
        }

        // 모든 숫자가 0인 경우 "0"을 반환
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();
    }
}