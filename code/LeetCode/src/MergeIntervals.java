import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    /*
    Merge Intervals
    Description
    Given a collection of intervals, merge all overlapping intervals.

    Example 1:

    Input: [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    Example 2:

    Input: [[1,4],[4,5]]
    Output: [[1,5]]
    Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
    Tags: Array, Sort
     */

    /*
    思路
    题意是给你一组区间，让你把区间合并成没有交集的一组区间。我们可以把区间按 start 进行排序，
    然后遍历排序后的区间，如果当前的 start 小于前者的 end，那么说明这两个存在交集，
    我们取两者中较大的 end 即可；否则的话直接插入到结果序列中即可。
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start > o2.start) {
                    return 1;
                }
                return 0;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> list = new ArrayList<>();
        for (int i = 1; i < intervals.size(); i++) {
            Interval item = intervals.get(i);
            if (end >= item.start) {
                end = Math.max(end, item.end);
            } else {
                list.add(new Interval(start, end));
                start = item.start;
                end = item.end;
            }
        }
        list.add(new Interval(start, end));

        return list;
    }





















































}
