import java.util.stream.IntStream;

public class NumberOfRemainingOne {

    public static void main(String[] args) {
        int n = 12;
        solution(n);
    }

    public static int solution(int n) {
        int answer = 0;
        while(true){
            if(n % ++answer == 1) break;
        }
        return answer;
    }

    // Stream 을 활용한 다른사람의 풀이
    public static int solution2(int n) {
        return IntStream.range(2,n).filter(i -> n % i == 1).findFirst().orElse(0);
    }
}
