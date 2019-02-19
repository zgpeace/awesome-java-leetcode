import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    /*
    Text Justification
    Description
    Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

    You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

    Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

    For the last line of text, it should be left justified and no extra space is inserted between words.

    Note:

    A word is defined as a character sequence consisting of non-space characters only.
    Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
    The input array words contains at least one word.
    Example 1:

    Input:
    words = ["This", "is", "an", "example", "of", "text", "justification."]
    maxWidth = 16
    Output:
    [
       "This    is    an",
       "example  of text",
       "justification.  "
    ]
    Example 2:

    Input:
    words = ["What","must","be","acknowledgment","shall","be"]
    maxWidth = 16
    Output:
    [
      "What   must   be",
      "acknowledgment  ",
      "shall be        "
    ]
    Explanation: Note that the last line is "shall be    " instead of "shall     be",
                 because the last line must be left-justified instead of fully-justified.
                 Note that the second line is also left-justified becase it contains only one word.
    Example 3:

    Input:
    words = ["Science","is","what","we","understand","well","enough","to","explain",
             "to","a","computer.","Art","is","everything","else","we","do"]
    maxWidth = 20
    Output:
    [
      "Science  is  what we",
      "understand      well",
      "enough to explain to",
      "a  computer.  Art is",
      "everything  else  we",
      "do                  "
    ]
    Tags: String
     */

    /*
    思路
    题意是给你一组单词和最大行宽，让你对齐他们，对齐的规则就是尽可能一行可以放下足够多的单词，如果最后有多余的空格，
    那就把空格均匀地插入到单词之间，如果不能平分的话，那就从左开始依次多插一个空格，最后一行单词之间就正常地一个空格即可，
    如果凑不到最大行宽，那就在末尾补充空格即可，描述地比较差，不懂的话其实看看 demo 也就懂了哈。
    题还是比较坑的，毕竟踩的比赞的人多，我也是靠模拟老老实实做出来的，求出可以最多插入空格数，然后用它除以可以插入的槽数
    获取每个单词之间的空格，它两取余的话就是最面需要多插入一个空格的个数，最后一行的话就单独处理即可。
     */

    public List<String> fullJustify(String[] words, int maxWidth) {
        int minBlank = 1;
        List<String> resultList = new ArrayList<String>();
        int wordsLen = words.length;
        int startIndex = 0;
        int currentLineLength = -1;
        StringBuilder blankBuilder = new StringBuilder();
        for (int i = 0; i < maxWidth; i++) {
            blankBuilder.append(" ");
        }

        //not the last line
        for (int i = 0; i < wordsLen; i++) {
            //line length <= max
            if (currentLineLength + words[i].length() + minBlank <= maxWidth) {
                currentLineLength += words[i].length() + minBlank;
            } else {
                int restBlank = maxWidth - currentLineLength;
                int holeNumbers = i - 1 - startIndex; //i is exclude

                StringBuilder subBuilder = new StringBuilder();
                subBuilder.append(words[startIndex]);

                //one word
                if (holeNumbers <= 0) {
                    subBuilder.append(blankBuilder.substring(0, restBlank));
                } else {
                    //more than one word
                    int blankPerHole = (restBlank / holeNumbers) + minBlank;
                    int remainderBlank = restBlank % holeNumbers;
                    for (int j = startIndex + 1; j < i; j++) {
                        if (remainderBlank-- > 0) {
                            //left add more one blank first
                            subBuilder.append(blankBuilder.substring(0, blankPerHole + 1)).append(words[j]);
                        } else {
                            subBuilder.append(blankBuilder.substring(0, blankPerHole)).append(words[j]);
                        }
                    }

                }
                //append new line string
                resultList.add(subBuilder.toString());

                //update data
                startIndex = i;
                currentLineLength = words[i].length();
            }
        }

        System.currentTimeMillis();

        //the last line
        StringBuilder lastLineBuilder = new StringBuilder();
        lastLineBuilder.append(words[startIndex]);
        for (int i = startIndex + 1; i < wordsLen; i++) {
            lastLineBuilder.append(" ").append(words[i]);
        }
        //fill tail blank
        int currentSubBuilderLen = lastLineBuilder.toString().length();
        if (currentSubBuilderLen < maxWidth) {
            lastLineBuilder.append(blankBuilder.substring(0, maxWidth - currentSubBuilderLen));
        }
        resultList.add(lastLineBuilder.toString());

        return resultList;
    }

    public static void main(String[] args) {
        TextJustification obj = new TextJustification();
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        List<String> resultList = obj.fullJustify(words, maxWidth);
        System.out.println(Arrays.toString(resultList.toArray()));
    }
































































}
