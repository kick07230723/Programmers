package stakcque;

import java.util.ArrayList;
import java.util.List;

public class DeleteDuplicate {

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        solution(arr);
    }

    public static int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(i == 0 || arr[i] != arr[i-1]) {
                list.add(arr[i]);
            }
        }
        // Stream을 이용한 List -> int[]
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}