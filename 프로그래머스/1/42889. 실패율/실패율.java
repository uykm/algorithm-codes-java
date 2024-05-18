import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int allChallengers = stages.length;
        // 각 스테이지 0 ~ N-1 에서 클리어한 사람 수
        int[] challengersCounts = new int[N];
        // 실패율
        double[] failRate = new double[N];
        
        for (int stage : stages) {
            if (stage == N+1) {
                continue;
            }
            
            int cp = challengersCounts[stage - 1];
            challengersCounts[stage - 1] = cp + 1;
        }
        
        for (int i = 0; i < challengersCounts.length; ++i) {
            int numerator = allChallengers - challengersCounts[i]; // 분자
            int denominator = allChallengers; // 분모
            failRate[i] = (double) numerator / denominator; // 실패율
            allChallengers -= challengersCounts[i];
        }
        
        FailRateWithStageNum[] fs = new FailRateWithStageNum[N];
        for (int i = 0; i < N; ++i) {
            fs[i] = new FailRateWithStageNum(i + 1, failRate[i]);
        }
        
        // 분수 배열을 내림차순으로 정렬
        Arrays.sort(fs, new Comparator<FailRateWithStageNum>() {
            @Override
            public int compare(FailRateWithStageNum fs1, FailRateWithStageNum fs2) {
                return Double.compare(fs1.getValue(), fs2.getValue()); // 내림차순으로 정렬
            }
        });
        
        int[] sortedStages = new int[N];
        for (int i = 0; i < N; ++i) {
            sortedStages[i] = fs[i].stageNum;
        }
        
        return sortedStages;
    }
    
    // "분수 값(실패율)"과 "인덱스+1 값(스테이지 번호)" 저장
    static class FailRateWithStageNum {
        double failRate; // 실패율
        int stageNum; // 스테이지 번호

        public FailRateWithStageNum(int stageNum, double failRate) {
            this.stageNum = stageNum;
            this.failRate = failRate;
        }

        // 분수를 비교하기 위해 분수의 값을 double로 반환하는 메소드
        public double getValue() {
            return failRate;
        }
    }
}