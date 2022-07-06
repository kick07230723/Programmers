public class StringExercise {

    public static void main(String[] args) {
        String str = "912345";
        System.out.println("RESULT : "+ solution(str) );
    }

    public static boolean solution(String s) {
        boolean answer = false;
        try {
            if(s.length()==4 || s.length()==6){
                Integer number = Integer.parseInt(s);
                if(number > 0)
                    answer = true;
            }
        }catch (Exception e){ e.printStackTrace(); }
        return answer;
    }

    // 정규식을 활용한 다른 사람의 풀이
    public static boolean solution2(String s) {
        boolean answer = false;
        if(s.length()==4 || s.length()==6){
            String pattern = "^[0-9]*$";
            return s.matches(pattern);
        }
        return answer;
    }
}
