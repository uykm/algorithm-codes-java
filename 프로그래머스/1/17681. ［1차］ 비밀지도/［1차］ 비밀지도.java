class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] row1 = new String[n];
        String[] row2 = new String[n];
        String[] result = new String[n];
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; ++i) {
            int tmp = arr1[i];
            boolean flag;
            for(int j = 0; j < n; ++j) {
                sb.append(tmp % 2);
                tmp /= 2;
            }
            row1[i] = sb.reverse().toString();
            
            sb = new StringBuilder();
            tmp = arr2[i];
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
                sb.append((binaryBit1 | binaryBit2) == 1 ? "#" : " ");
            }
            result[i] = sb.toString();
        }
        
        return result;
    }
}