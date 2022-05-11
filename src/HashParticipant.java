import java.util.*;

public class HashParticipant {

    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "josipa", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        solution(participant, completion);
    }

    /* 힌트보고 재작성 */
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> participantMap = new HashMap<>();
        
        for (String partName : participant) {
            participantMap.put(partName, participantMap.getOrDefault(partName, 0)+1);
        }
        
        for (String compName : completion) {
            participantMap.put(compName, participantMap.get(compName)-1);
        }

        for(String name : participantMap.keySet()){
            if(participantMap.get(name) == 1){
                answer = name;
            }
        }
        System.out.println("###  answer : "+answer);
        return answer;
    }

    /* ArrayList를 활용 -> 라인은 줄었지만, 성능에서 또 걸림 */
    public static String solutionSecond(String[] participant, String[] completion) {
        String answer = "";
        List<String> participantList = new ArrayList<>();
        for (String person : participant) {
            participantList.add(person);
        }
        for (String comp : completion) {
            participantList.remove(comp);
        }
        answer=participantList.get(0);
        System.out.println("###  answer : "+answer);
        return answer;
    }

    /* 중첩 loop를 이용한 풀이 -> 속도에서 걸림 */
    public static String solutionFirst(String[] participant, String[] completion) {
        String answer = "";
        List<String> participantList = new ArrayList<>();
        for (String person : participant) {
            participantList.add(person);
        }
        for (String comp : completion) {
            for (int i = 0; i < participantList.size(); i++) {
                if(comp.equals(participantList.get(i))){
                    participantList.remove(i);
                    break;
                }
            }
        }
        answer = participantList.get(0);
        System.out.println("###  answer : " + answer);
        return answer;
    }
}
