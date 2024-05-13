class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] fourWords = {"aya", "ye", "woo", "ma"};
        
        for (String b : babbling) {
            int cantSpeakStrLen = b.length();
            String strToCheckSpeakAgain = "";
            String strToCompare1 = "";
            String strToCompare2 = "";
            for (int i = 0; i < b.length(); ++i) {
                int startIndex = i;
                if (startIndex + 2 <= b.length()) {
                    strToCompare1 = b.substring(startIndex, startIndex + 2);
                } else {
                    strToCompare1 = "";
                }
                if (startIndex + 3 <= b.length()) {
                    strToCompare2 = b.substring(startIndex, startIndex + 3);
                } else {
                    strToCompare2 = "";
                }
                for (String fw : fourWords) {
                    if (strToCompare1.equals(strToCheckSpeakAgain) 
                        || strToCompare2.equals(strToCheckSpeakAgain)
                       && !strToCheckSpeakAgain.equals("")) {
                        strToCheckSpeakAgain = "";
                        break;
                    }
                    if (strToCompare1.equals(fw) || strToCompare2.equals(fw)) {
                        strToCheckSpeakAgain = fw;
                        i += fw.length() - 1;
                        cantSpeakStrLen -= fw.length();
                        break;
                    }
                }
            }
            
            if (cantSpeakStrLen == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}