import java.util.HashMap;
import java.util.HashSet;

public class Pokemon {

    public static void main(String[] args){
        int[] nums = {3,3,3,2,2,4};
        int result = solution(nums);
        System.out.println("### Result : "+ result);
    }


    public static int solution(int[] nums) {
        int answer = 0;
        // arr -> hash : 중복제거 (hashMap)
//        HashMap<String, Integer> tempMap = new HashMap<>();
//        for (int num : nums) {
//            tempMap.put(String.valueOf(num), 0);
//        }

        // arr -> hash : 중복제거 (hashSet)
        HashSet<Integer> tempSet = new HashSet<>();
        for(int i =0; i<nums.length;i++) {
            tempSet.add(nums[i]);
        }

        // map 크기 중 arr/2 크기 만큼 해서 최댓값 구하기
        int kindCount = tempSet.size();
        int selectCount = nums.length/2;
        return Math.min(kindCount, selectCount);
    }
}
