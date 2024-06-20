class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        char prev = '?';
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (Character.isAlphabetic(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || (ch == '.' && prev != '.')) {
                sb.append(Character.toLowerCase(ch));
                prev = ch;
            }
        }

        int start = 0, end = sb.length();
        if (sb.charAt(0) == '.' && end != 1)
            start = 1;
        if (sb.charAt(end-1) == '.')
            end--;
        String answer = sb.substring(start, end);

        if (answer.equals(""))
            answer = "a";

        if (answer.length() > 15)
            answer = answer.charAt(14) == '.' ? answer.substring(0, 14)
                                              : answer.substring(0, 15);
        
        char tail = answer.charAt(answer.length()-1);
        while (answer.length() < 3) {
            answer += tail;
        }

        return answer;
    }
}

// class Solution {
//     public String solution(String new_id) {
//         // 1단계: 모든 대문자를 대응되는 소문자로 치환
//         String answer = new_id.toLowerCase();
        
//         // 2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
//         answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
//         // 3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
//         answer = answer.replaceAll("\\.{2,}", ".");
        
//         // 4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거
//         answer = answer.replaceAll("^\\.|\\.$", "");
        
//         // 5단계: 빈 문자열이라면, "a"를 대입
//         if (answer.equals("")) {
//             answer = "a";
//         }
        
//         // 6단계: 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
//         //       만약 제거 후 마침표(.)가 끝에 위치한다면 끝에 위치한 마침표(.)도 제거
//         if (answer.length() >= 16) {
//             answer = answer.substring(0, 15);
//             answer = answer.replaceAll("\\.$", "");
//         }
        
//         // 7단계: 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 붙임
//         while (answer.length() <= 2) {
//             answer += answer.charAt(answer.length() - 1);
//         }
        
//         return answer;
//     }
// }