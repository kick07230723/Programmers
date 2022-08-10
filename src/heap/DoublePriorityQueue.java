package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

    public static void main(String[] args) {
        String[] operations = {"I 1", "I 2", "I 3", "I 4", "I 5", "D -1", "D -1","D -1", "D -1"};
        System.out.println("####  - "+Arrays.toString(solution(operations)));
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQue = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> minQue = new PriorityQueue();

        for (String str:operations) {
            String[] operation = str.split(" ");
             if(operation[0].equals("I")) { // insert
                 maxQue.add(Integer.parseInt(operation[1]));
                 minQue.add(Integer.parseInt(operation[1]));
             }else if (operation[0].equals("D")){ // delete
                 if(maxQue.size()==0) continue;

                 if("1".equals(operation[1])){  // 최대값 삭제 및 동기화
                     minQue.remove(maxQue.remove());
                 }else if("-1".equals(operation[1])){ // 최소값 삭제 및 동기화
                     maxQue.remove(minQue.remove());
                 }
             }
        }
        answer[0] = maxQue.size()>0 ? maxQue.remove():0;
        answer[1] = minQue.size()>0 ? minQue.remove():0;
        return answer;
    }

}
