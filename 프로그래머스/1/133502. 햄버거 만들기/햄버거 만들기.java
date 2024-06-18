// class Solution {
//     public int solution(int[] ingredient) {
//         int hamburgers = 0;
//         StringBuilder sb = new StringBuilder();
        
//         for (int i : ingredient) {
//             sb.append(i);
//             // 만약 현재 마지막 4글자가 "1231"이라면
//             if (sb.length() >= 4 && sb.substring(sb.length() - 4).equals("1231")) {
//                 sb.delete(sb.length() - 4, sb.length());
//                 hamburgers++;
//             }
//         }
        
//         return hamburgers;
//     }
// }

class Solution {
    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            if (sp >= 4 && stack[sp - 1] == 1
                && stack[sp - 2] == 3
                && stack[sp - 3] == 2
                && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }
}