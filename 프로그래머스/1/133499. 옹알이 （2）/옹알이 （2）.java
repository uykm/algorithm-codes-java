class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] fourWords = {"aya", "ye", "woo", "ma"};
        
        for (String b : babbling) {
            boolean isValid = true;
            String lastWord = "";  // 마지막으로 체크한 발음 가능한 단어을 저장
            int i = 0;
            
            while (i < b.length() && isValid) {
                boolean matched = false;
                for (String word : fourWords) {
                    if (i + word.length() <= b.length() && b.startsWith(word, i)) {
                        if (word.equals(lastWord)) {
                            // 연속된 발음 발견
                            isValid = false;
                            break;
                        }
                        lastWord = word;  // 가장 최근에 매칭한 단어로 업데이트
                        i += word.length();  // 발음한 단어 길이만큼 인덱스 이동
                        matched = true;
                        break;
                    }
                }
                
                if (!matched) {  // 매칭되는 발음이 없으면 종료
                    isValid = false;
                }
            }
            
            if (isValid && i == b.length()) {  // 모두 가능한 발음들로 이뤄진 경우
                answer++;
            }
        }
        
        return answer;
    }
}