package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class DiscController {

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println("####  - " + solution(jobs) );
    }

    public static int solution(int[][] jobs) {
        // 총 시간은 대기시간(가변)+실행시간(불변)이므로, 대기시간이 짧을수록 짧아진다
        // 대기시간(=시작시간-요청시간)을 짧게 하려면, 수행시간이 짧은걸 먼저 처리(SJF)

        // 중요 개념 : 선점SJF 와 비슷
        // 작업을 요청 시점 순으로 담고 있는 작업 큐
        // 소요시간이 적은 순으로 작업을 수행하는 작업 큐
        // 요청 시점에 가능한 작업들을 작업 큐에 넘겨주면, 소요시간이 적은 순서대로 우선순위를 부여하여 작업을 수행

        int seconds = 0;
        // jobs를 요청시간으로 정렬(asc)하는 prioirtyQueue 생성
        PriorityQueue<Integer[]> jobQue = new PriorityQueue<>((o1, o2) -> o1[0].compareTo(o2[0]) );

        // int[] -> Integer[] -> prioirtyQueue에 삽입
        for (int[] job : jobs) {
            jobQue.add(Arrays.stream(job).boxed().toArray(Integer[]::new));
        }

        // 계산
        int size = jobQue.size();
        int totalSeconds = 0;
        while(!jobQue.isEmpty()){
            if(seconds < jobQue.peek()[0]){
                seconds++;
                continue;
            }

            // 해당 시점에 실행할 수 있는 job관리 큐
            PriorityQueue<Integer[]> availableQue = new PriorityQueue<>((o1,o2) -> o1[1].compareTo(o2[1]));
            while(!jobQue.isEmpty() && jobQue.peek()[0] <= seconds){
                availableQue.add(jobQue.poll());
            }

            // 대기시간(=시작시간-요청시간) + 실행시간
            Integer[] currentJob = availableQue.poll();
            totalSeconds += seconds - currentJob[0] + currentJob[1];

            // 쓰지 않은 job은 모두 복구
            jobQue.addAll(availableQue);

            // 현재 작업 실행 완료 시점으로 jump!
            seconds += currentJob[1];
        }

        return Math.round(totalSeconds/size);
    }

}
