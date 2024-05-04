class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int cnt = 0;
        boolean flag = true;
        
        while (flag) {
            cnt = 0;
            while (n >= a) {
                n -= a;
                cnt++;
            }
            
            n += cnt * b;
            answer += cnt * b;
            
            if(n < a) flag = false;
        }
        
        return answer;
    }
}