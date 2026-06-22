class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder answer = new StringBuilder();

        int cycle = 2 * numRows - 2;
        int n = s.length();

        for (int row = 0; row < numRows; row++) {
            for (int base = row; base < n; base += cycle) {
                answer.append(s.charAt(base));

                // base = 일직선 줄에 들어갈 인덱스, middle = 대각선 줄에 들어갈 인덱스
                int middle = base + cycle - 2 * row;

                // 지그재그로 펼쳤을 때 맨 위/아래 row는 필요 X
                if (row != 0 && row != numRows - 1 && middle < n) { 
                    answer.append(s.charAt(middle));
                }
            }
        }

        return answer.toString();
    }
}