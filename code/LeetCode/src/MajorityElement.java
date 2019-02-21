import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int majorityKey = 0;
        int majorityCount = 0;

        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num: nums) {
            if (numCountMap.containsKey(num)) {
                numCountMap.put(num, numCountMap.get(num) + 1);
                if (numCountMap.get(num) > majorityCount) {
                    majorityCount = numCountMap.get(num);
                    majorityKey = num;
                }
            } else  {
                numCountMap.put(num, 1);
            }
        }

        return majorityKey;
    }

    public static void main(String[] args) {
        int[] inputNums = {2,2,1,1,1,2,2};
        System.out.println("Output: " + new MajorityElement().majorityElement(inputNums));
    }
}
