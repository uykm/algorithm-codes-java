class Solution {
    public int solution(int n) {
        int answer = 0;
        String ternary = "";
        
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            if(n/3 == 0) {
                sb.append(n%3);
                break;
            }
            sb.append(n%3);
            n /= 3;
        }
        
        ternary = sb.reverse().toString();
        
        int tmp = 1;
        for (char ch : ternary.toCharArray()) {
            int curExp = ch - '0';
            answer += tmp * curExp;
            tmp *= 3;
        }
        
        
        return answer;
    }
}