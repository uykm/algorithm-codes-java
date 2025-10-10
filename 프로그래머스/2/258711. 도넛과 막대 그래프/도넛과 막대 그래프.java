import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> nodes = new HashMap<>(); // int[] -> 나오는 간선 수, 들어오는 간선 수
        
        int extraNode = -1; // 생성된 정점
        int doughnut = 0; // 도넛 그래프 개수
        int stick = 0;	// 막대 그래프 개수
        int eight = 0;  // 8자 그래프 개수


	    // 각 노드에 연결된 간선 개수 계산
        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];

            if (!nodes.containsKey(from)) {
                nodes.put(from, new int[]{0,0});
            }
            if (!nodes.containsKey(to)) {
                nodes.put(to, new int[]{0,0});
            }
          
            nodes.get(from)[0]++; // from에서 나오는 간선 수 ++
            nodes.get(to)[1]++; // to로 들어오는 간선 수 ++
        }

        // 노드를 탐색하며 각 그래프의 '핵심 노드' 찾으면 개수 갱신
        for (int node : nodes.keySet()) {
            int out = nodes.get(node)[0];
            int in = nodes.get(node)[1];

            // 나가는 간선이 2개 이상이고, 들어오는 간선이 없을 경우
            if (out >= 2 && in == 0) {
                extraNode = node;
            }
            // 막대 그래프: 나가는 간선이 없고, 들어오는 간선만 있을 경우 
            else if (out == 0 && in > 0) {
                stick++;
            }
            // 8자 그래프: 들어오는 것과 나가는 것이 각 2개 이상일 경우
            else if (out == 2) {
                eight++;
            }
        }

        // 도넛 그래프 수 = (추가한 노드에서 나오는 간선의 개수 = 전체 그래프의 수) - (나머지 그래프 수)
        doughnut = nodes.get(extraNode)[0] - stick - eight;

        return new int[]{extraNode, doughnut, stick, eight};

    }
}