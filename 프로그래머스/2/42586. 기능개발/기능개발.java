import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        // 담겨있는 값: 가장 마지막으로 배포된 프로젝트까지 걸린 시간
        Queue<Integer> passedDate = new LinkedList<>();
        
        for (int i = 0; i < speeds.length; ++i) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            // i 번째 프로젝트를 개발 완료하기 위해 필요한 시간(일)
            int requiredDate = (int) Math.ceil(remain);
            
            // 배포 시작: (아직 완료처리 되지 않은 프로젝트 ~ i-1 번째 프로젝트)
            if (!passedDate.isEmpty() && passedDate.peek() < requiredDate) {
                // passedDate.size(): 배포를 기다리고 있는 개발 완료된 프로젝트 수
                answer.add(passedDate.size()); 
                passedDate.clear();
            }
            
            passedDate.offer(requiredDate); // i번째 프로젝트까지 배포 완료됐다고 가정
        }
        
        answer.add(passedDate.size());
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}