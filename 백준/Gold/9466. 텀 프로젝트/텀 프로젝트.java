import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BFS로 T * N * N(100,000) 탐색시 시간 초과
public class Main {
    static int T, N;
    static int count;
    static int[] selectedStudent;
    static boolean[] visited;
    static boolean[] cycleCheckConfirmed; //

    // 방향 그래프에서 사이클을 찾는 문제는 DFS
    // https://thin-azimuth-2a9.notion.site/DFS-13cf4ee21c0080279529f70ade160e94?pvs=4
    // (무방향 그래프에서 사이클 찾는 문제는 Union-Find)
    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bufferReader.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            N = Integer.parseInt(bufferReader.readLine());
            selectedStudent = new int[N];
            cycleCheckConfirmed = new boolean[N];
            visited = new boolean[N];

            StringTokenizer st = new StringTokenizer(bufferReader.readLine());
            for (int from = 0; from < N; from++) {
                int to = Integer.parseInt(st.nextToken()) - 1; // 1을 빼주거나 배열 크기를 +1 해주거나
                selectedStudent[from] = to;
            }

            count = 0;

            for (int i = 0; i < N; i++) {
                if (cycleCheckConfirmed[i]) { // 팀(사이클)이 형성되지 않은 학생인 경우
                    continue;
                }
                dfs_recursion(i);
            }

            sb.append(N - count);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs_recursion(int cur) {
        if (cycleCheckConfirmed[cur]) return; // 팀 가능 여부를 이미 체크
        if(visited[cur]) { // 해당 노드를 이미 방문한 적이 있다 -> 사이클
            cycleCheckConfirmed[cur] = true;
            count++;
        } else { // 첫 방문
            visited[cur] = true; // 방문처리
        }

        int next = selectedStudent[cur];
        dfs_recursion(next);

        visited[cur] = false; // 방문체크 초기화
        cycleCheckConfirmed[cur] = true; // 팀이 형성되지 않은 학생도 처리
    }
}