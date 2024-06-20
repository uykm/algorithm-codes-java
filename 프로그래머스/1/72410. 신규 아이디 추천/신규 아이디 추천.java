class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        boolean prevDot = false;

        // 1단계, 2단계, 3단계: 문자를 소문자로 변환, 허용된 문자만 사용, 연속된 마침표 제거
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
            }
            if (Character.isLowerCase(ch) || Character.isDigit(ch) || ch == '-' || ch == '_') {
                sb.append(ch);
                prevDot = false;
            } else if (ch == '.' && !prevDot) {
                sb.append(ch);
                prevDot = true;
            }
        }

        // 4단계: 마침표가 처음이나 끝에 위치한다면 제거
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 5단계: 빈 문자열이라면 "a" 대입
        if (sb.length() == 0) {
            sb.append('a');
        }

        // 6단계: 길이가 16자 이상이면 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        if (sb.length() > 15) {
            sb.setLength(15);
            if (sb.charAt(14) == '.') {
                sb.deleteCharAt(14);
            }
        }

        // 7단계: 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 붙임
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
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