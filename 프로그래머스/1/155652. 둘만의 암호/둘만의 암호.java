class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int i = 0;
            int pwd = c;
            while (i < index) {
                boolean doSkip = false;
                pwd = pwd + 1;
                if (pwd > 'z') {
                    pwd = 'a';
                }
                for (char sk : skip.toCharArray()) {
                    if (pwd == sk) {
                        doSkip = true;
                        break;
                    }
                }
                if(doSkip) {
                    continue;
                }
                i++;
            }
            sb.append((char)pwd);
        }
        
        return sb.toString();
    }
}