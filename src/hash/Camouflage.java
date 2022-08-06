package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Camouflage {

    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println("####  Result : "+solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> clothesMap = new HashMap<>();
        // Hash로 저장
        for (int i = 0; i < clothes.length; i++) {
            clothesMap.put(clothes[i][1], clothesMap.get(clothes[i][1])==null ? 2:clothesMap.get(clothes[i][1])+1);
        }

        // Hash를 이용해 key(카테고리), value(count++) 해서 count 계산
        for (String category :clothesMap.keySet()) {
            answer *= clothesMap.get(category);
        }

        // count들 끼리 곱 한후 -1 (모두 0을 고른 경우)
        return answer-1;
    }
}
