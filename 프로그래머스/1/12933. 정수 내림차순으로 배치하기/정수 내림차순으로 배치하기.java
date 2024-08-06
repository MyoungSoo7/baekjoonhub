import java.util.Arrays;
class Solution {
    public long solution(long n) {
        String str = Long.toString(n);
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr)).reverse();
        return Long.parseLong(sb.toString());
    }
}