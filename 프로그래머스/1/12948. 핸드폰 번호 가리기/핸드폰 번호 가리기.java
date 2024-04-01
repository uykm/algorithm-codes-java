class Solution {
    public String solution(String phone_number) {
    
        boolean flag = false; // 4자리 남았는지 체크
        int cnt = 0; // 체크한 문자 수
        StringBuilder sb = new StringBuilder();
        
        for (char ch : phone_number.toCharArray()) {
            
            if (cnt == phone_number.length()-4) {
                flag = true;
            }
            
            if (flag == true) {
                sb.append(ch);
            } else {
                sb.append("*");
            }
            
            cnt++;
        }
        
        return sb.toString();
    }
}