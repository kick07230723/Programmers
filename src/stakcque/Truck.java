package stakcque;

import java.util.*;
import java.util.stream.Collectors;

public class Truck {

    public static void main(String[] args){
        int[] arr = {7,4,5,6};
        int result = solution(2,10,arr);
        System.out.println("### Result : "+ result);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int seconds = 0;
        int truckIndex = 0;
        int passingWeights = 0;
        Queue<Integer> passingTruck = new LinkedList<>();

        while(truck_weights.length > truckIndex){
            seconds++;

            // 건너가는 트럭이 있다면 앞에서 하나씩 제거
            if(passingTruck.size() == bridge_length){
                passingWeights -= passingTruck.poll();
            }

            if(weight >= passingWeights + truck_weights[truckIndex]){
                // 다리 하중이 괜찮다면, 한 대 더 건너가기
                passingTruck.add(truck_weights[truckIndex]);
                passingWeights += truck_weights[truckIndex];
                truckIndex++;
            }else{
                passingTruck.add(0);
                // 다라 하중이 꽉차면, 다리 위의 트럭만 1칸 건너가기
            }
        }
        return seconds+bridge_length;
    }
}
