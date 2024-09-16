class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        // 서로소가 나올 때까지 인수분해한다.
        for (int i = 2; i <= 100; ) {
            boolean canDivide = false;
            
            // 배열 내 모든 값을 약수로 나눠본다.
            for (int j = 0; j < arr.length; ++j) {
                if (arr[j] % i == 0) {
                    arr[j] /= i;
                    canDivide = true;
                }
            }
            
            // 어떤 값도 나누어떨어지지 않으면 i보다 1이 큰 값으로 인수분해한다.
            if (!canDivide) {
                i++;
            } else { // 그게 아니면 약수(i)를 곱해준다.
                answer *= i; 
            }
        }
        
        // 남은 서로소 값들을 곱한다
        for (int a : arr) {
            answer *= a;
        }
        
        return answer;
    }
}