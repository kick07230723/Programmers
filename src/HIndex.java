import java.util.ArrayList;
import java.util.Collections;

public class HIndex {

    public static void main(String[] args) {
        int[] arr ={0,1,2};
        solution(arr);
    }

    public static int solution(int[] citations) {
        int answer = 0;
        ArrayList<Integer> citationList = new ArrayList();
        for(int num : citations) {citationList.add(num);}
        Collections.sort(citationList, Collections.reverseOrder());

        if(citationList.get(0)==0) return 0;

        for(int h=citationList.size()-1; h>=0; h--){
            if(h < citationList.get(h)){
                answer = h+1;
                break;
            }
        }
        return answer;
    }
}
