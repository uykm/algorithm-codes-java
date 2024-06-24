import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        HashMap<String, Integer> hsmp = new HashMap<>();
        for (String t : terms) {
            String[] term = t.split(" ");
            hsmp.put(term[0], Integer.valueOf(term[1]));
        }
        
        String[] td = today.split("\\.");
        int[] tdInt = new int[3];
        for (int i = 0; i < 3; ++i) {
            tdInt[i] = Integer.valueOf(td[i]);
        }
        
        // 파기해야 할 개인정보 리스트
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; ++i) {
            boolean isValid = false;
            // privacy[0] : 유효기간, privacy[1] : 약관 종류
            String[] privacy = privacies[i].split(" ");
            
            // date[0] : 연도, date[1] : 월, date[2] : 일
            String[] date = privacy[0].split("\\.");
            int[] dateInt = new int[3];
            for (int j = 0; j < 3; ++j) {
                dateInt[j] = Integer.valueOf(date[j]);
            }
            
            int month = dateInt[1];
            int term = hsmp.get(privacy[1]);
            if ((month + term) > 12) {
                if ((month + term) % 12 == 0) {
                    dateInt[0] += (month + term) / 12 - 1;
                    dateInt[1] = 12;
                } else {
                    dateInt[0] += (month + term) / 12;
                    dateInt[1] = (month + term) % 12;
                }
            } else {
                dateInt[1] = month + term;
            }
            
            for (int j = 0; j < 3; ++j) {
                if (dateInt[j] < tdInt[j]) { // 유효 기간이 끝난 경우
                    break;
                } else if (dateInt[j] > tdInt[j]) { // 유효 기간이 남아있는 경우
                    isValid = true;
                    break;
                }
            }
            
            if (!isValid) {
                list.add(i+1);
            }
        }
        
        Collections.sort(list);
        
        // 정수형 배열 생성
        int[] answer = new int[list.size()];
        
        // 리스트의 요소를 배열에 복사
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}