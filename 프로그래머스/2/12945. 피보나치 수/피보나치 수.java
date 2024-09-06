class Solution {
    public int solution(int n) {
        int answer = 1;
        int fm1 = 1;
        int fm2 = 0;
        
        for (int i = 2; i <= n; ++i) {
            answer = (fm1 + fm2) % 1234567;
            fm2 = fm1;
            fm1 = answer;
        }
        
        return answer;
//         int[] fibonacci = new int[100001];
//         fibonacci[0] = 0;
//         fibonacci[1] = 1;
        
//         for (int i = 2; i <= n; ++i) {
//             fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % 1234567;
//         }
        
//         return fibonacci[n];
    }
}