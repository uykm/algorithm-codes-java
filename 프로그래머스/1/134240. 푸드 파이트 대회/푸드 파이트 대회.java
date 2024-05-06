class Solution {
    public String solution(int[] food) {
        
        StringBuilder sb = new StringBuilder();
        StringBuilder answerSb = new StringBuilder();
        
        for (int i = 1; i < food.length; ++i) {
            int leftFoodsNum = food[i] / 2;
            for(int j = 0; j < leftFoodsNum; ++j) {
                sb.append(String.valueOf(i));
            }
        }
        
        answerSb.append(sb.toString());
        answerSb.append("0");
        answerSb.append(sb.reverse().toString());
        
        return answerSb.toString();
    }
}