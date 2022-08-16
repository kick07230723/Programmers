package bruteForce;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    public static void main(String[] args) {
        int[][] arr = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        solution(arr);
    }


    public static int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0;
        int maxHeight = 0;
        // Math 대체 가능
        for(int[] size : sizes){
            if(size[0] > size[1]){
                if(size[0] > maxWidth) maxWidth = size[0];
                if(size[1] > maxHeight) maxHeight = size[1];
            } else {
                if(size[1] > maxWidth) maxWidth = size[1];
                if(size[0] > maxHeight) maxHeight = size[0];
            }
        }
        answer = maxWidth * maxHeight;
        return answer;
    }

}
