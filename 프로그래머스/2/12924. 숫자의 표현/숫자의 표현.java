class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; ++i) {
            int tmp = i;
            int sum = 0;
            boolean flag = false;
            while (sum <= n) {
                sum += tmp;
                if (sum == n) flag = true;
                tmp++;
            }
            if (flag) answer++;
        }
        return answer;
    }
}