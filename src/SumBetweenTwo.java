import java.util.stream.IntStream;

public class SumBetweenTwo {

    public static void main(String[] args) {
        System.out.println("RESULT : "+ solution(5, 3));
    }

    public static long solution(int a, int b) {
        int biggerNum = 0;
        int smallerNum = 0;
        long answer = 0;
        if(a>b){
            biggerNum = a;
            smallerNum = b;
        }else{
            biggerNum = b;
            smallerNum = a;
        }
        for(int i=smallerNum; i<=biggerNum; i++){
            answer += i;
        }
        return answer;
    }


    // 내 초기 답과 비슷 : return (a+b) / 2 * (Math.abs(b-a)+1); 절대값으로 하는 바람에 음수만 있는 경우 문제발생!
    // method를 나눠서, 등차수열 합
    public long solution2(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }

    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }
}
