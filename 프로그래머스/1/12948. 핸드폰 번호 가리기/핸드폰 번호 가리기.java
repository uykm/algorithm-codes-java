class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false; // 4자리 남았는지 체크
        int cnt = 0;
        
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