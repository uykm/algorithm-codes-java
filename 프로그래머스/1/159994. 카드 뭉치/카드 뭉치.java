class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        boolean flag = true;
        int index1 = 0;
        int index2 = 0;
        
        // 순서대로 나오는지 cards1, cards2 각각 체크
        for (int i = 0; i < goal.length; ++i) {
            if (index1 < cards1.length && cards1[index1].equals(goal[i])) {
                index1++;
                continue;
            }
            
            if (index2 < cards2.length && cards2[index2].equals(goal[i])) {
                index2++;
                continue;
            }
            
            flag = false;
            break;
        }
        
        return flag ? "Yes" : "No";
    }
}