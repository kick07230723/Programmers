import java.util.ArrayList;

public class AddingSomeNumbers {

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        solution(numbers);
    }

    public static int solution(int[] numbers) {
        int answer = 0;
        ArrayList<Integer> numbersList = new ArrayList<>();

        for (int number : numbers) {
            numbersList.add(number);
        }
        for(int i = 0; i < 10; i++){
            if(!numbersList.contains(i))
                answer += i;
        }

        return answer;
    }
}
