import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        System.out.println("len: " + len);
        int sum = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; --i) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String input1 = "III";
        String input2 = "IV";
        String input3 = "IX";
        String input4 = "LVIII";
        String input5 = "MCMXCIV";

        System.out.println("input: " +input1+ " output:" + romanToInt(input1));
        System.out.println("input: " +input2+ " output:" + romanToInt(input2));
        System.out.println("input: " +input3+ " output:" + romanToInt(input3));
        System.out.println("input: " +input4+ " output:" + romanToInt(input4));
        System.out.println("input: " +input5+ " output:" + romanToInt(input5));
    }
}
