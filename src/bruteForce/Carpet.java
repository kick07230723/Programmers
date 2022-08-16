package bruteForce;

public class Carpet {

    public static void main(String[] args) {
        solution(10, 2);
    }


    public static int[] solution(int brown, int yellow) {
//        수학적 풀이 필요 (1.for문 사용 2.근의공식) => 1로 풀었지만, 2가 성능이 좋음
//        yellow*brown = 가로*세로
//        yellow = (가로-2)*(세로-2)
        int[] answer = new int[2];
        for (int tempWidth = yellow+2; tempWidth > 0; tempWidth--) {
            int tempHeight = (brown+yellow)/tempWidth;
            if((tempWidth-2) * (tempHeight-2) == yellow){
                answer[0]=tempWidth;
                answer[1]=tempHeight;
                break;
            }
        }
        return answer;
    }

}
