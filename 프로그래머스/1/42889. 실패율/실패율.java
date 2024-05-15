import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int allChallengers = stages.length;
        // 각 스테이지 0 ~ N-1 에서 클리어한 사람 수
        int[] challengersCounts = new int[N];
        // index 0: 분자 / index 1: 분모
        int[][] failRate = new int[N][2];
        
        for (int stage : stages) {
            if (stage == N+1) {
                continue;
            }
            
            int cp = challengersCounts[stage - 1];
            challengersCounts[stage - 1] = cp + 1;
        }
        
        for (int i = 0; i < challengersCounts.length; ++i) {
            failRate[i][0] = allChallengers - challengersCounts[i]; // 분자
            failRate[i][1] = allChallengers; // 분모
            allChallengers -= challengersCounts[i];
        }
        
        FailRateWithStageNum[] fs = new FailRateWithStageNum[N];
        for (int i = 0; i < N; ++i) {
            fs[i] = new FailRateWithStageNum(i + 1, failRate[i][0], failRate[i][1]);
        }
        
        // 분수 배열을 내림차순으로 정렬
        Arrays.sort(fs, new Comparator<FailRateWithStageNum>() {
            @Override
            public int compare(FailRateWithStageNum frac1, FailRateWithStageNum frac2) {
                return Double.compare(frac1.getValue(), frac2.getValue()); // 내림차순으로 정렬
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
        int numerator; // 분자
        int denominator; // 분모
        int stageNum; // 스테이지 번호

        public FailRateWithStageNum(int stageNum, int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            this.stageNum = stageNum;
        }

        // 분수를 비교하기 위해 분수의 값을 double로 반환하는 메소드
        public double getValue() {
            return (double) numerator / denominator;
        }
    }
}