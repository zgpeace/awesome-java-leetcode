package array;

public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int zeroCount = 0;
    int len = nums.length;
    int current;
    for(int i = 0; i <len; i++) {
      current = nums[i];
      // value == 0 then count++
      if (current == 0) {
        zeroCount++;
      } else {
        // value != 0 then move forward
        nums[i - zeroCount] = current;
        if (zeroCount != 0) {
          nums[i] = 0;
        }
      }
    }
  }

  public void moveZeroesWithFillReminderZero(int[] nums) {
    int zeroCount = 0;
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      if (nums[i] == 0) {
        zeroCount++;
        continue;
      }
      nums[i - zeroCount] = nums[i];
    }

    int left = len - zeroCount;
    while (left < len) {
      nums[left] = 0;
      left++;
    }
  }

  public void moveZeroWithSwithZero(int[] nums) {
    int zeroCount = 0;
    int temp;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        temp = nums[zeroCount];
        nums[zeroCount] = nums[i];
        nums[i] = temp;
        zeroCount++;
      }
    }
  }
}
