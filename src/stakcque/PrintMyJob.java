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
        Integer biggestNum = 0;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> sortedPriorities = new ArrayList();
        for (int num: priorities) {
            queue.add(num);
            sortedPriorities.add(num);
        }
        sortedPriorities.sort(Collections.reverseOrder());

        while(true){
            biggestNum = sortedPriorities.get(answer);
            if (location == 0 && queue.peek() == biggestNum){
                answer++;
                break;
            } else if ((Integer)queue.peek() < biggestNum){
                queue.add(queue.poll());
            } else {
                queue.poll();
                answer++;
            }

            if(location==0)
                location = queue.size()-1;
            else
                location--;
        }

        return answer;
    }

}