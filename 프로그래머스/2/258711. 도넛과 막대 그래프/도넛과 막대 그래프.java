import java.util.*;

class Solution {
    private static int nodeCount = 0; // 전체 정점의 개수
    private static List<List<Integer>> graph = new ArrayList<>(); // 각 정점의 간선 정보
    private static List<Integer> entranceCount = new ArrayList<>(); // 각 정점으로 들어오는 간선의 개수
    private static boolean[] visited; // 방문 여부

    public int[] solution(int[][] edges) {
        int donut = 0, stick = 0, eight = 0;

        // 1. 정점 개수 파악
        for (int[] edge : edges) {
            nodeCount = Math.max(nodeCount, Math.max(edge[0], edge[1]));
        }
        visited = new boolean[nodeCount + 1];

        // 2. 그래프 초기화
        for (int i = 0; i <= nodeCount; i++) {
            graph.add(new ArrayList<>());
            entranceCount.add(0);
        }

        // 3. 간선 정보 입력
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            entranceCount.set(edge[1], entranceCount.get(edge[1]) + 1);
        }

        // 4. 생성 정점 탐색
        int startNum = findStartNum();
        List<Integer> startWay = graph.get(startNum);

        // 5. 생성 정점과 연결된 정점의 간선 제거
        for (int node : startWay) {
            entranceCount.set(node, entranceCount.get(node) - 1);
        }

        // 6. 그래프 파악
        for (int node : startWay) {
            if (!visited[node]) {
                int type = findGraph(node);
                if (type == 0) donut++;
                else if (type == 1) stick++;
                else if (type == 2) eight++;
            }
        }

        return new int[]{startNum, donut, stick, eight};
    }

    // 생성 정점 탐색
    private static int findStartNum() {
        for (int i = 1; i <= nodeCount; i++) {
            if (graph.get(i).size() >= 2 && entranceCount.get(i) == 0) {
                return i;
            }
        }
        return -1;
    }

    // 그래프 탐색 및 유형 판별
    private static int findGraph(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (graph.get(node).size() == 2 && entranceCount.get(node) == 2) {
                return 2; // 8 형태
            } else if (graph.get(node).isEmpty()) {
                return 1; // 막대 형태
            } else {
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
        return 0; // 도넛 형태
    }
}