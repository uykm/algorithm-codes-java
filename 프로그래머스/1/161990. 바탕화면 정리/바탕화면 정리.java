class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int startX = 50, startY = 0, endX = 0, endY = 0;
        int col = wallpaper.length;
        int row = wallpaper[0].length();
        boolean firstCheck = true;
        
        for (int i = 0; i < col; ++i) {
            for (int j = 0; j < row; ++j) {
                if (wallpaper[i].charAt(j) == '#') {
                    
                    // 드래그 시작점의 가로 좌표
                    startX = Math.min(startX, j);
                    
                    // 드래그 끝점의 가로 좌표
                    endX = Math.max(endX, j);
                    
                    // 첫 번째 파일의 세로 좌표를 드래그 시작점의 세로 좌표로 시정
                    if (firstCheck) { 
                        startY = i;
                        firstCheck = false;
                    }
                    
                    // 드래그 끝점의 세로 좌표
                    endY = i;
                }
            }
        }
        
        // 드래그 시작점
        answer[0] = startY;
        answer[1] = startX;
        // 드래그 끝점
        answer[2] = endY + 1;
        answer[3] = endX + 1;
        
        return answer;
    }
}