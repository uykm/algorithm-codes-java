class Solution {
    public int solution(int[] ingredient) {
        int hamburgers = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int i : ingredient) {
            sb.append(i);
            // 만약 현재 마지막 4글자가 "1231"이라면
            if (sb.length() >= 4 && sb.substring(sb.length() - 4).equals("1231")) {
                sb.delete(sb.length() - 4, sb.length());
                hamburgers++;
            }
        }
        
        return hamburgers;
    }
}

// class Solution {
//     public int solution(int[] ingredient) {
//         int hamburgers = 0;
        
//         int count = 0;
//         String s = "";
//         StringBuilder sb = new StringBuilder();
        
//         for (int i : ingredient) {
//             sb.append(String.valueOf(i));
//         }
        
//         s = sb.toString();
        
//         while (true) {
//             int index = s.indexOf("1231");
//             if (index == -1) break;
//             hamburgers++;
//             sb = new StringBuilder();
//             sb.append(s.substring(0, index));
//             sb.append(s.substring(index+4, s.length()));
//             s = sb.toString();
//         }
        
//         return hamburgers;
//     }
// }