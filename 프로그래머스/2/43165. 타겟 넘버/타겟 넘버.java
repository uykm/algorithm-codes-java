class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return answer;
    }
    
    public void dfs(int index, int[] numbers, int target, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(index + 1, numbers, target, sum + numbers[index]);
        dfs(index + 1, numbers, target, sum - numbers[index]);
    }
}