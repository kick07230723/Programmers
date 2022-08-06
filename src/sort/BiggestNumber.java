package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BiggestNumber {

    public static void main(String[] args) {
        int[] arr ={3, 30, 34, 5, 9};
        solution(arr);
    }

    public static String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> strings = new ArrayList();
        for (Integer num : numbers) {
            strings.add(num.toString());
        }
        Collections.sort(strings, Collections.reverseOrder());

        if(strings.get(0)=="0"){
            return "0";
        }

        for (int i=0; i<strings.size(); i++) {
            if(i<strings.size() && Integer.parseInt(strings.get(i)+strings.get(i+1)) < Integer.parseInt(strings.get(i+1)+strings.get(i))){
                // 0이 들어가는 경우 다음 숫자와 비교 필요 (ex.정렬후 30,3 => 330 > 303)
                answer += strings.get(i) + strings.get(i++);
            }else{
                // 그외 일반적인 경우
                answer += strings.get(i);
            }
        }
        return answer;
    }

    public String solution2(int[] numbers) {

        // 숫자를 문자열로 변환
        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        // 정렬
        Arrays.sort(result, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 0만 여러개 있는 배열의 경우 하나의 0만 리턴
        if (result[0].equals("0")) {
            return "0";
        }

        String answer = "";
        // 정렬된 문자 하나로 합치기
        for (String a : result) {
            answer += a;
        }
        return answer;
    }

}
