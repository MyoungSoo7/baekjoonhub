import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수를 저장할 맵
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 장르별 노래 리스트를 저장할 맵
        Map<String, List<Song>> genreSongs = new HashMap<>();

        // 노래 정보를 Song 객체로 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);

            if (!genreSongs.containsKey(genre)) {
                genreSongs.put(genre, new ArrayList<>());
            }
            genreSongs.get(genre).add(new Song(i, play));
        }

        // 장르별 총 재생 횟수를 기준으로 내림차순 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        // 결과를 저장할 리스트
        List<Integer> bestAlbum = new ArrayList<>();

        // 각 장르별로 가장 많이 재생된 노래를 두 개씩 선택
        for (String genre : sortedGenres) {
            List<Song> songs = genreSongs.get(genre);
            songs.sort((a, b) -> {
                if (b.play == a.play) {
                    return a.id - b.id;
                } else {
                    return b.play - a.play;
                }
            });

            bestAlbum.add(songs.get(0).id);
            if (songs.size() > 1) {
                bestAlbum.add(songs.get(1).id);
            }
        }

        // 리스트를 배열로 변환하여 반환
        return bestAlbum.stream().mapToInt(i -> i).toArray();
    }
     // 노래 정보를 저장할 클래스
    class Song {
        int id;
        int play;

        Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }
}