class Solution {
    public String reverseWords(String s) {
        
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (c == ' ') {
                if (word.length() > 0) {
                    words.add(word.toString());
                    word.delete(0, word.length());
                }
            }
            else {
                word.append(c);
            }
        }

        if (word.length() > 0) {
            words.add(word.toString());
        }

        StringBuilder answer = new StringBuilder();

        for (int i = words.size() - 1; i >= 0; --i) {
            answer.append(words.get(i));

            if (i > 0) {
                answer.append(' ');
            }
        }

        return answer.toString();
    }
}