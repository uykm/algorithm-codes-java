import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int totalScore = 0;
        int[] scores = new int[3];
        int index = 0;              // 현재 점수 인덱스
        
        int length = dartResult.length();
        int i = 0;
        
        while (i < length) {
            // 점수 계산
            StringBuilder scoreBuilder = new StringBuilder();
            while (i < length && Character.isDigit(dartResult.charAt(i))) { // 점수 추출
                scoreBuilder.append(dartResult.charAt(i));
                i++;
            }
            int score = Integer.parseInt(scoreBuilder.toString()); 
            // Integer.parseInt() : 기본형으로 반환
            // Integer.valueOf() : 참조형으로 반환
            
            // 보너스 계산
            char bonus = dartResult.charAt(i);
            i++;
            if (bonus == 'S') {
                score = (int) Math.pow(score, 1);
            } else if (bonus == 'D') {
                score = (int) Math.pow(score, 2);
            } else if (bonus == 'T') {
                score = (int) Math.pow(score, 3);
            }
            
            // 옵션 계산
            if (i < length && (dartResult.charAt(i) == '*' || dartResult.charAt(i) == '#')) {
                char option = dartResult.charAt(i);
                if (option == '*') {
                    score *= 2;
                    if (index > 0) {
                        scores[index - 1] *= 2;
                    }
                } else if (option == '#') {
                    score *= -1;
                }
                i++;
            }
            
            scores[index++] = score;
        }
        
        for (int s : scores) {
            totalScore += s;
        }
        
        return totalScore;
    }
}