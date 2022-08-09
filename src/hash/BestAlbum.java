package hash;

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {

    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution(genres, plays);
        System.out.println("### Result : "+ result);
    }


    public static int[] solution(String[] genres, int[] plays) {

        ArrayList<Integer> result =  new ArrayList();
        // map에 넣기 (장르+재생, 장르별 재생수용)
        Map playCountMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            playCountMap.put(genres[i], (int)(playCountMap.get(genres[i])==null ? 0:playCountMap.get(genres[i]))+plays[i]);
        }

        // 정렬(장르별 재생수 합산)
        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(playCountMap.entrySet());
        Collections.sort(entryList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));


        // 장르별 최대 2곡씩 선택
        for (Map.Entry<String, Integer> song : entryList) {
            int first = 0;
            int firstIndex = 0;
            int second = 0;
            int secondIndex = 0;

            for (int i = 0; i < genres.length; i++) {
                if(genres[i].equals(song.getKey())){
                    if(plays[i] > first){
                        second = first;
                        secondIndex = firstIndex;
                        first = plays[i];
                        firstIndex = i;
                    } else if(plays[i] > second){
                        second = plays[i];
                        secondIndex = i;
                    }
                }
            }
            result.add(firstIndex);
            if(second>0) result.add(secondIndex);
        }

        // arrList->arr
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}