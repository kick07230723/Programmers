package bruteForce;

import java.util.ArrayList;
import java.util.List;

public class MockExam {

    public static void main(String[] args) {
        int[] arr = {1,1,1};
        solution(arr);
    }

//    public static List<Integer> solution(int[] answers) {
//        List<Integer> answer = new ArrayList<>();
//        int[] personA = {1, 2, 3, 4, 5}; // length:5
//        int[] personB = {2, 1, 2, 3, 2, 4, 2, 5}; // length:8
//        int[] personC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // length:10
//
//        int countA = 0;
//        int countB = 0;
//        int countC = 0;
//
//        // 고정하지말고 length를 사용해서 유연하게 대처
//        for (int i = 0; i <answers.length; i++) {
//            if(answers[i] == personA[i%5]) countA++;
//            if(answers[i] == personB[i%8]) countB++;
//            if(answers[i] == personC[i%10]) countC++;
//        }
//
//        int checkNum = countA;
//        answer.add(1);
//        if(checkNum == countB){
//            answer.add(2);
//        }else if(checkNum < countB){
//            checkNum = countB;
//            answer.add(2);
//            answer = new ArrayList<>();
//        }
//        if(checkNum == countC){
//            answer.add(3);
//        }else if(checkNum < countC){
//            answer = new ArrayList<>();
//            answer.add(3);
//        }
//
//        System.out.println("### answer : "+answer);
//        return answer;
//    }


    public static List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList();
        int[] personA = {1, 2, 3, 4, 5}; // length:5
        int[] personB = {2, 1, 2, 3, 2, 4, 2, 5}; // length:8
        int[] personC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // length:10

        int[] hits = {0,0,0};

        for (int i = 0; i <answers.length; i++) {
            if(answers[i] == personA[i%personA.length]) hits[0]++;
            if(answers[i] == personB[i%personB.length]) hits[1]++;
            if(answers[i] == personC[i%personC.length]) hits[2]++;
        }

        int max = 0;
        for (int i = 0; i < hits.length; i++) {
            if(max < hits[i]){
                max = hits[i];
                answer =  new ArrayList();
                answer.add(i+1);
            } else if(max == hits[i]){
                answer.add(i+1);
            }
        }

        System.out.println("### answer : "+answer);
        return answer;
    }

}
