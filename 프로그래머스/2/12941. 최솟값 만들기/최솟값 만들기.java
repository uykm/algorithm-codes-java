import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Integer[] boxedB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        
        // 가장 작은 것과 가장 큰 것을 곱하도록
        Arrays.sort(A);
        Arrays.sort(boxedB, Collections.reverseOrder());
        
        for (int i = 0; i < A.length; ++i) {
            answer += A[i] * boxedB[i];
        }
        

        return answer;
    }
}