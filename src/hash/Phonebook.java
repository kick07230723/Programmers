package hash;

import java.util.Arrays;

public class Phonebook {

    public static void main(String[] args) {
        String[] phone_book = {"12", "123", "1235", "567", "88"};
        System.out.println("###    RESULT  : "+ solution(phone_book));
    }

    // String 정렬(12,123,1235,222,..) 후 비교
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        return true;
    }

    // 이중 for문 사용 - 효율성 테스트에서 걸림
    public static boolean solution2(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if(i != j && phone_book[i].startsWith(phone_book[j])) return false;
            }
        }
        return true;
    }
}
