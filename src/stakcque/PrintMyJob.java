package stakcque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class PrintMyJob {

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        solution(priorities, location);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        // 필요한 변수 생성 (가장 높은 우선순위, 정렬된 우선순위, 우선순위 리스트)
        Integer biggestNum = 0;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> sortedPriorities = new ArrayList();
        for (int num: priorities) {
            queue.add(num);
            sortedPriorities.add(num);
        }
        sortedPriorities.sort(Collections.reverseOrder());

        while(true){
            // 큐에서 하나씩 빼거나, 빼서 맨 뒤로 보내거나
            biggestNum = sortedPriorities.get(answer);
            if (location == 0 && queue.peek() == biggestNum){
                answer++;
                break;
            } else if (queue.peek() < biggestNum){
                queue.add(queue.poll());
            } else {
                queue.poll();
                answer++;
            }

            // 내가 선택한 작업의 위치 관리하기
            if(location==0)
                location = queue.size()-1;
            else
                location--;
        }

        return answer;
    }

}