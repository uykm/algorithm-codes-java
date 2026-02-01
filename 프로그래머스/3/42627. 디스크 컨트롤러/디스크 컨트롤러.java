import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1) 요청시간 기준 정렬
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        // 2) 소요시간 기준 min-heap (duration -> request)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] != b[1]) return a[1] - b[1]; // duration
                return a[0] - b[0]; // request
            }
        );

        int n = jobs.length;
        int idx = 0;          // jobs 배열에서 아직 pq에 안 넣은 다음 작업 인덱스
        int time = 0;         // 현재 시간
        long total = 0;       // 턴어라운드 합 (완료시간 - 요청시간)

        while (idx < n || !pq.isEmpty()) {
            // 현재 시간까지 들어온 작업을 pq에 넣기
            while (idx < n && jobs[idx][0] <= time) {
                pq.offer(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                // 처리할 작업이 없으면, 다음 작업 요청시간으로 시간 점프
                time = jobs[idx][0];
                continue;
            }

            int[] job = pq.poll();
            int request = job[0];
            int duration = job[1];

            time += duration;                // 실행 후 현재 시간
            total += (time - request);       // 완료시간 - 요청시간
        }

        return (int) (total / n);
    }
}