import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String html = br.readLine();

        // <main> ~ </main> 범위 추출
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

                // <div title="..."> → "title : ..."
                if (tag.startsWith("<div")) {
                    String title = extractTitle(tag);
                    if (!title.isEmpty()) out.append("title : ").append(title).append('\n');
                }

                // <p> 시작
                if (!inP && tag.equals("<p>")) {
                    inP = true;
                    pBuf.setLength(0);
                }
                // </p> 종료 → 비어 있어도 한 줄 출력
                else if (inP && tag.equals("</p>")) {
                    inP = false;
                    out.append(pBuf).append('\n');
                    pBuf.setLength(0);
                }
                // 그 외 태그(<br>, <i>, </i> 등) 무시
                i = j + 1;
            } else {
                if (inP) pBuf.append(ch);
                i++;
            }
        }

        // 🔹 전역 후처리: 모든 줄을 cleanText 방식으로 정리
        BufferedReader lineReader = new BufferedReader(new StringReader(out.toString()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = lineReader.readLine()) != null) {
            result.append(cleanText(line)).append('\n');
        }

        // 정답 코드처럼 마지막 개행은 제거하지 않음
        System.out.print(result);
    }

    private static String extractTitle(String tag) {
        int t = tag.indexOf("title=\"");
        if (t == -1) return "";
        t += 7;
        int end = tag.indexOf('"', t);
        if (end == -1) return "";
        return tag.substring(t, end); // 제목은 원문 그대로
    }

    // 공백 정리: 연속 공백 1칸, 앞뒤 공백 제거
    private static String cleanText(String s) {
        StringBuilder sb = new StringBuilder();
        boolean prevSpace = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (!prevSpace) { sb.append(' '); prevSpace = true; }
            } else {
                sb.append(c);
                prevSpace = false;
            }
        }

        int len = sb.length();
        if (len > 0 && sb.charAt(0) == ' ') sb.deleteCharAt(0);
        len = sb.length();
        if (len > 0 && sb.charAt(len - 1) == ' ') sb.deleteCharAt(len - 1);
        return sb.toString();
    }
}