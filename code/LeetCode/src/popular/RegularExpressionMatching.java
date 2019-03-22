package popular;

enum Result {
    TRUE, FALSE;
}

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        // p is empty
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // first char firstCharMatch : 1. string first char is == , 2. or p  first string == '.'
        boolean firstCharMatch = s.length() >= 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // p second char == '*', 1. then isMatch(s, p.substring(2)), 2. firstCharMatch && isMatch(s.substring(1), p)
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstCharMatch && isMatch(s.substring(1), p));
        } else {
            // p second char != '*', then firstCharMatch &&  isMatch(s.substring(1), p.substring(1))
            return firstCharMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    Result[][] memo;

    public boolean isMatchWithMemory(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        memo = new Result[s.length() + 1][p.length() + 1];
        return subMatch(0, 0, s, p);
    }

    public boolean subMatch(int textIndex, int patternIndex, String text, String pattern) {
        if (memo[textIndex][patternIndex] != null) {
            return memo[textIndex][patternIndex] == Result.TRUE;
        }
        boolean result = false;
        if (patternIndex == pattern.length()) {
            result = textIndex == text.length();
        } else {
            boolean firstCharMatch = text.length() > textIndex &&
                    (text.charAt(textIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.');
            if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
                result = subMatch(textIndex, patternIndex + 2, text, pattern) ||
                        (firstCharMatch && subMatch(textIndex + 1, patternIndex, text, pattern));
            } else {
                result = firstCharMatch && subMatch(textIndex + 1, patternIndex + 1, text, pattern);
            }
        }

        memo[textIndex][patternIndex] = result ? Result.TRUE : Result.FALSE;

        return result;
    }


    public static void main(String[] args) {
        RegularExpressionMatching obj = new RegularExpressionMatching();
        String s = "aa";
        String p = "a";
        System.out.println("Output: " + obj.isMatch(s, p));
        System.out.println("isMatchWithMemory Output: " + obj.isMatchWithMemory(s, p));
        String s1 = "aa";
        String p1 = "a*";
        System.out.println("Output1: " + obj.isMatch(s1, p1));
        System.out.println("isMatchWithMemory Output1: " + obj.isMatchWithMemory(s1, p1));
        String s2 = "ab";
        String p2 = ".*";
        System.out.println("Output2: " + obj.isMatch(s2, p2));
        System.out.println("isMatchWithMemory Output2: " + obj.isMatchWithMemory(s2, p2));
        String s3 = "aab";
        String p3 = "c*a*b";
        System.out.println("Output3: " + obj.isMatch(s3, p3));
        System.out.println("isMatchWithMemory Output3: " + obj.isMatchWithMemory(s3, p3));
        String s4 = "mississippi";
        String p4 = "mis*is*p*.";
        System.out.println("Output4: " + obj.isMatch(s4, p4));
        System.out.println("isMatchWithMemory Output4: " + obj.isMatchWithMemory(s4, p4));

    }
}
