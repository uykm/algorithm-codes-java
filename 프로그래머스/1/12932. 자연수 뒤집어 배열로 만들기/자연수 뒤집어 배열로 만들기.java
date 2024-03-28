class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n); 
        // 문자열 연산은 객체를 생성하기 때문에, 메모리 사용 측면에서 비효율적 !
        int[] answer = new int[str.length()];
        
        for(int i = 0; i < str.length(); i++) {
            answer[i] = str.charAt(str.length()-1-i) - '0';
        }
        
        return answer;
    }
}