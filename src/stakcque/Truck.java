package stakcque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Truck {

    public static void main(String[] args){
        int[] arr = {7,4,5,6};
        int result = solution(2,10,arr);
        System.out.println("### Result : "+ result);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        List<Integer> waitingTrucks = Arrays.stream(truck_weights).boxed().collect(Collectors.toList());
        ArrayList<Integer> passingTrucks = new ArrayList<>();

        while(passingTrucks.size()>0 || waitingTrucks.size()>0){
            answer++;
            // 다리를 건너는중 -> 지난
            if(passingTrucks.size()>0){
                passingTrucks.remove(0);
                continue;
            }
            // 대기 -> 건너는중
            if(waitingTrucks.size()>0){
                passingTrucks.add(waitingTrucks.get(0));
                waitingTrucks.remove(0);
                continue;
            }

        }
        return answer;
    }
}
