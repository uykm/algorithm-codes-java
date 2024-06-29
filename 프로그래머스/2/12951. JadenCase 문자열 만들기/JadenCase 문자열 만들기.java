class Solution {
    public String solution(String s) {
        boolean isFirstCh = true;
        
        StringBuilder sb = new StringBuilder();
        int head = 0;
        for (char c : s.toCharArray()) {
            if (isFirstCh) { // 띄어쓰기 직후 문자
                if (c == ' ') {
                    sb.append(" ");
                    isFirstCh = true;
                    continue; // 또 띄어쓰기가 나온 경우
                } else if ('a' <= c && c <= 'z') { // 첫 문자가 소문자 알파벳인 경우
                    sb.append((char)(c - 32));
                } else { // 첫 문자이고 대문자인 경우, 숫자이거나 알파벳인 경우
                    sb.append(c); 
                }
            } else {
                if ('A' <= c && c <= 'Z') {
                    sb.append((char)(c + 32)); // 첫 문자가 아닌데, 대문자 알파벳인 경우
                } else {
                    sb.append(c);
                }
            }
            
            if (c == ' ') isFirstCh = true;
            else isFirstCh = false;
        }
        
        return sb.toString();
    }
}