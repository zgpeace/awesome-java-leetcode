package popular;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return s;
        }
        String blankString = " ";
        String[] wordsArray = s.split(blankString);
        StringBuilder sb = new StringBuilder();

        for (int i = wordsArray.length - 1; i >= 0; i--) {
            String word =  wordsArray[i];
            word = word.trim();
            if (word.length() > 0) {
                sb.append(word).append(blankString);
            }
        }

        return sb.toString().trim();
    }

    public String reverseWordsWithLessSpace(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        // step 1. reverse the whole string
        subReverse(chars, 0, len - 1);
        // step 2. reverse each word
        subReverseWords(chars, len);
        // step 3. clean up spaces
        return subCleanBlankChar(chars, len);
    }

    // trim leading, trailing and multiple spaces
    public String subCleanBlankChar(char[] chars, int len) {
        int i = 0, j = 0;
        char blankChar = ' ';
        while (j < len) {
            // skip spaces
            while (j < len && chars[j] == blankChar) {
                j++;
            }
            // keep non spaces
            while (j < len && chars[j] != blankChar) {
                chars[i++] = chars[j++];
            }
            // skip spaces
            while (j < len && chars[j] == blankChar) {
                j++;
            }
            // keep only one space
            if (j < len) {
                chars[i++] = blankChar;
            }
        }

        return new String(chars).substring(0, i);
    }

    public void subReverseWords(char[] chars, int len) {
        char blankChar = ' ';
        int i = 0, j = 0;
        while (j < len) {
            // skip spaces
            while (j < len && chars[j] == blankChar) {
                j++;
            }
            i = j;
            // skip non spaces
            while (j < len && chars[j] != blankChar) {
                j++;
            }
            // reverse the word
            subReverse(chars, i, j - 1);
        }
    }

    // reverse a[] from a[i] to a[j]
    public void subReverse(char[] chars, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            char temp = chars[startIndex];
            chars[startIndex] = chars[endIndex];
            chars[endIndex] = temp;

            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
        String input = "the sky is blue";
        ReverseWordsInAString obj = new ReverseWordsInAString();
        //System.out.println("Input: \"" + input + "\"\n" + "Output: \"" + obj.reverseWords(input) + "\"") ;
        System.out.println("Input: \"" + input + "\"\n" + "Output: \"" + obj.reverseWordsWithLessSpace(input) + "\"") ;

        String input1 = "  hello world!  ";
        //System.out.println("Input: \"" + input1 + "\"\n" + "Output: \"" + obj.reverseWords(input1) + "\"") ;
        System.out.println("Input: \"" + input1 + "\"\n" + "Output: \"" + obj.reverseWordsWithLessSpace(input1) + "\"") ;

        String input2 = "a good   example";
        //System.out.println("Input: \"" + input2 + "\"\n" + "Output: \"" + obj.reverseWords(input2) + "\"") ;
        System.out.println("Input: \"" + input2 + "\"\n" + "Output: \"" + obj.reverseWordsWithLessSpace(input2) + "\"") ;
    }
}
