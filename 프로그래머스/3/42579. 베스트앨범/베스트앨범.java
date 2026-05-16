import java.util.*;

class Solution {
    class Music implements Comparable<Music> {

        int idx;
        int cnt;

        @Override
        public int compareTo(Music m) {
            return m.cnt - this.cnt;
        }
        
        public Music(int idx, int cnt){
            this.idx=idx;
            this.cnt=cnt;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르별 총 재생수
        Map<String, Integer> genrePlay = new HashMap<>();

        // 장르별 노래 목록
        Map<String, List<Music>> genreMusic = new HashMap<>();

        for(int i=0;i<genres.length;i++){
            String genre = genres[i];

            genrePlay.put(
                    genre,
                    genrePlay.getOrDefault(genre, 0) + plays[i]
            );
            
            List<Music> m = genreMusic.getOrDefault(genre, new ArrayList<>());
            m.add(new Music(i, plays[i]));
            
            genreMusic.put(genre, m);
        }
        
        
        // 장르 정렬
        List<String> genreList = new ArrayList<>(genrePlay.keySet());

        genreList.sort((a, b) ->
                genrePlay.get(b) - genrePlay.get(a)
        );
        
        
        List<Integer> answer = new ArrayList<>();
        for(String g:genreList){
            
            List<Music> musics = genreMusic.get(g);
            Collections.sort(musics);

            for(int i = 0; i < Math.min(2, musics.size()); i++) {
                answer.add(musics.get(i).idx);
            }
        }

        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}