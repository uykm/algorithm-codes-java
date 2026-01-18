import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCountMap = new HashMap<>();
        Map<String, List<Integer>> genreSongNumMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlayCountMap.put(genres[i],
                    genrePlayCountMap.getOrDefault(genres[i], 0) + plays[i]);

            genreSongNumMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
        }

        // 장르 총합 재생수 내림차순 정렬
        List<Map.Entry<String, Integer>> sortedGenres =
                new ArrayList<>(genrePlayCountMap.entrySet());
        sortedGenres.sort((a, b) -> b.getValue() - a.getValue());

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : sortedGenres) {
            String genre = entry.getKey();
            List<Integer> songIdxs = genreSongNumMap.get(genre);

            // 해당 장르의 노래를 (재생수 내림차순, 고유번호 오름차순)으로 정렬
            songIdxs.sort((i, j) -> {
                if (plays[i] != plays[j]) return plays[j] - plays[i];
                return i - j;
            });

            // 상위 2개까지 뽑기
            result.add(songIdxs.get(0));
            if (songIdxs.size() > 1) result.add(songIdxs.get(1));
        }

        // List<Integer> -> int[]
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);

        return answer;
    }
}