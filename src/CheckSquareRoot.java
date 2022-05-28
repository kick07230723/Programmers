import java.util.Arrays;

public class CheckSquareRoot {

    public static void main(String[] args) {
        long number = 121;
        solution(number);
    }

    public static long solution(long n) {
        long answer = 0;

        long x = (long) Math.sqrt(n);
        if(x*x == n) {
            answer = (x+1)*(x+1);
        }else{
            answer = -1;
        }

        System.out.println("### answer : "+answer);
        return answer;
    }
}
