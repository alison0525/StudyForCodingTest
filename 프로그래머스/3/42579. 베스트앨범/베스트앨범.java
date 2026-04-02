import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String,Integer> totals = new HashMap<>();
        Map<String, List<int[]>> songs = new HashMap<>();
        
        for(int i=0; i<plays.length; i++){
            totals.put(genres[i],totals.getOrDefault(genres[i], 0)+plays[i]);
            if(!songs.containsKey(genres[i])){
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{i,plays[i]});
                songs.put(genres[i], list);
            }else{
                List<int[]> list = songs.get(genres[i]);
                list.add(new int[]{i,plays[i]});
                songs.put(genres[i], list);
            }
        }
        
        List<String> genreRank = new ArrayList<>(totals.keySet());
        
        genreRank.sort((a,b)-> totals.get(b) - totals.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        for (String genre : genreRank) {
            List<int[]> list = songs.get(genre);
            list.sort((a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return b[1] - a[1];
            });
            for (int i = 0; i < Math.min(2, list.size()); i++) {
                result.add(list.get(i)[0]);
            }
        }
        
        answer = result.stream()
            .mapToInt(i->i)
            .toArray();
        
        return answer;
    }
}