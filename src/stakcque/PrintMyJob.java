package stakcque;

import java.util.ArrayList;
import java.util.List;

public class PrintMyJob {

    public static void main(String[] args) {
        int[] priorities = {2,1,3,2};
        int location = 2;
        solution(priorities, location);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        for (int i = 0; i < priorities.length; i++) {
            int bigNum = 0;
            for (int j = i; j < priorities.length; j++) {
//                priorities[i]
            }
        }
        return answer;
    }

}