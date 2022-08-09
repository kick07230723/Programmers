package heap;

import java.util.PriorityQueue;

public class KScoville {

    public static void main(String[] args) {
        int[] scoville = { 9, 10, 12, 1, 2, 3};
        solution(scoville, 10);
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        // 우선순위큐(힙)에 넣어 정렬
        PriorityQueue<Integer> kScoville = new PriorityQueue();
        int zeroCount = 0;
        for (int scovilleIndex : scoville) {
            kScoville.offer(scovilleIndex);
            if(scovilleIndex==0) zeroCount++;
            if(zeroCount==1) return -1;
        }

        while (kScoville.peek() < K) {
            // 스코빌 섞기
            if(kScoville.size()==1) return -1;
            answer++;
            kScoville.offer(kScoville.poll() + (kScoville.poll() * 2));

        }

        return answer;
    }

}
