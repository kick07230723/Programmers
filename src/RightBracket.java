import java.util.Stack;

class RightBracket {

    public static void main(String[] args) {
        String str = "()()";
        boolean result = solution(str);
        System.out.println("### Result : " + result);
    }

    static boolean solution(String s) {
        boolean answer = false;
        Stack<Integer> criteria = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                criteria.push(0);
            }else if (c == ')'){
                if (criteria.empty()) return false;
                criteria.pop();
            }
        }

        // split의 경우 효율성 검사에서 떨어짐
//        if (s.length()==0) return false;
//        String[] strArr = s.split("");
//        for (String str:strArr) {
//            if (str.equals("(")){
//                criteria.push(0);
//            }else if (str.equals(")")){
//                if (criteria.empty()) return false;
//                criteria.pop();
//            }
//        }

        if (criteria.empty()) answer = true;
        return answer;
    }
}