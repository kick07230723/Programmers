package stakcque;

import java.util.ArrayList;
import java.util.List;

public class StockPrices {

    public static void main(String[] args) {
        int[] arr = {1,2,3,2,3};
        solution(arr);
    }

    public static int[] solution(int[] prices) {
        List<Integer> secondsArr = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            int seconds = 0;
            for (int j = i; j < prices.length; j++) {
                if (prices[i] > prices[j] || j == prices.length-1) {
                    secondsArr.add(seconds);
                    break;
                }else{
                    seconds ++;
                }
            }
        }
        return secondsArr.stream().mapToInt(Integer::intValue).toArray();
    }

}