package stakcque;

import java.util.ArrayList;
import java.util.List;

public class ProgressAndDeployment {

    public static void main(String[] args) {
        int[] progresses ={93,30,55};
        int[] speeds ={1,30,5};
        solution(progresses, speeds);
    }

    public static List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList();
        int days=0;
        int progress = 0;
        int deployNum = 0;
        for (int i = 0; i < progresses.length; i++) {
            while(true) {
                progress = progresses[i] + (speeds[i] * days);
                if(progress >= 100){
                    deployNum++;
                    break;
                }else{
                    if(deployNum>0){
                        answer.add(deployNum);
                        deployNum=0;
                    }
                    days++;
                }
            }
        }
        answer.add(deployNum);
        return answer;
    }

//    public static List<Integer> solution2(int[] progresses, int[] speeds) {
//        List<Integer> answer = new ArrayList();
//        int days=0;
//        int deployNum = 0;
//
//        for (int i = 0; i < progresses.length; i++) {
//            while(progresses[i] + (speeds[i] * days) < 100) {
//                days++;
//                if(deployNum>0){
//                    answer.add(deployNum);
//                    deployNum=0;
//                }
//            }
//            deployNum++;
//        }
//        return answer;
//    }
}
