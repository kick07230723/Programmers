public class NumberOfFactors {

    public static void main(String[] args) {
        solution(13, 17); // 43
    }

    public static int solution(int left, int right) {
        int answer = 0;

        for(int i=left; i<=right; i++){
            if(Math.ceil(Math.sqrt(i)) == Math.floor(Math.sqrt(i))){
                answer -= i;
            }else{
                answer += i;
            }

        }
        System.out.println("###  answer : "+answer);
        return answer;
    }
}
