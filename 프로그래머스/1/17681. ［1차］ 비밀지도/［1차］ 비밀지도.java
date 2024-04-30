class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] row1 = new String[n];
        String[] row2 = new String[n];
        String[] result = new String[n];
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; ++i) {
            int tmp = arr1[i];
            // arr1을 2진수로 변환
            for(int j = 0; j < n; ++j) {
                sb.append(tmp % 2);
                tmp /= 2;
            }
            row1[i] = sb.reverse().toString();
            
            sb = new StringBuilder();
            tmp = arr2[i];
            // arr2를 2진수로 변환
            for(int j = 0; j < n; ++j) {
                sb.append(tmp % 2);
                tmp /= 2;
            }
            row2[i] = sb.reverse().toString();
        }
        
        for(int i = 0; i < n; ++i) {
            sb = new StringBuilder();
            for(int j = 0 ; j < n; ++j) {
                int binaryBit1 = row1[i].charAt(j) - '0';
                int binaryBit2 = row2[i].charAt(j) - '0';
                // 비트 연산자는 피연산자로 10진수를 넣어도 정상적으로 작동하더라
                sb.append((binaryBit1 | binaryBit2) == 1 ? "#" : " ");
            }
            result[i] = sb.toString();
        }
        
        return result;
    }
}

/*

class Solution { 
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < arr1.length; ++i)
            answer[i] = fomat(n, Integer.toBinaryString(arr1[i]|arr2[i]));
        
        return answer;
    }
    
    // n칸 맞추기 + " #  #" 형태로 포맷팅하기 
    public String fomat(int n, String binary) {
        StringBuilder result = new StringBuilder();
        int l = binary.length();
        
        for(int i = 0; i < n - l; ++i) result.append(" ");
        for(int i = 0; i < l; ++i) {
            if(binary.charAt(i) == '1') result.append("#");
            else result.append(" ");
        }
        
        return result.toString();
    }
}

*/