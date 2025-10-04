import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String html = br.readLine();

        // <main> ~ </main> 범위: 정답 코드와 동일하게 고정 길이로 자르기
        int s = "<main>".length();
        int e = "</main>".length();
        html = html.substring(s, html.length() - e);

        StringBuilder out = new StringBuilder();
        StringBuilder pBuf = new StringBuilder();
        boolean inP = false;

        for (int i = 0, n = html.length(); i < n; ) {
            char ch = html.charAt(i);

            if (ch == '<') {
                int j = html.indexOf('>', i);
                if (j == -1) break;
                String tag = html.substring(i, j + 1);

                // <div title="..."> -> "title : ...\n"
                if (tag.startsWith("<div")) {
                    String title = extractTitle(tag); // 제목은 원문 그대로
                    if (!title.isEmpty()) out.append("title : ").append(title).append('\n');
                }

                // <p> 시작 (문제 데이터는 <p>로 온다고 가정: 정답 정규식도 <p>만 매칭)
                if (!inP && tag.equals("<p>")) {
                    inP = true;
                    pBuf.setLength(0);
                }
                // </p> 종료 -> ★비어 있어도 한 줄 출력 (정답의 $1\n과 동일)
                else if (inP && tag.equals("</p>")) {
                    inP = false;
                    out.append(pBuf).append('\n'); // cleanText 적용하지 않음
                    pBuf.setLength(0);
                }
                // 그 외 태그(<i>, </i>, <br>, ...)는 전부 무시
                i = j + 1;
            } else {
                if (inP) pBuf.append(ch); // p 내부 일반 텍스트만 수집
                i++;
            }
        }

        // 정답 코드와 동일한 전역 후처리 (제목 포함 전체에 적용)
        String result = out.toString();
        result = result.replaceAll(" ?\n ?", "\n"); // 줄 앞/뒤 공백 제거
        result = result.replaceAll(" {2,}", " ");   // 다중 공백 1칸

        // 정답 코드처럼 마지막 개행을 제거하지 않음
        System.out.print(result);
    }

    private static String extractTitle(String tag) {
        int t = tag.indexOf("title=\"");
        if (t == -1) return "";
        t += 7;
        int end = tag.indexOf('"', t);
        if (end == -1) return "";
        return tag.substring(t, end); // 제목은 가공 없이
    }
}