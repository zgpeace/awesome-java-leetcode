import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertInterval {
    /*
    Insert Interval
    Description
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

    You may assume that the intervals were initially sorted according to their start times.

    Example 1:

    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    Output: [[1,5],[6,9]]
    Example 2:

    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    Output: [[1,2],[3,10],[12,16]]
    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
    Tags: Array, Sort
     */

    /*
    思路
    题意是给你一组有序区间，和一个待插入区间，让你待插入区间插入到前面的区间中，我们分三步走：

    首先把有序区间中小于待插入区间的部分加入到结果中；

    其次是插入待插入区间，如果有交集的话取两者交集的端点值；

    最后把有序区间中大于待插入区间的部分加入到结果中；
     */

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.isEmpty()) {
            return Collections.singletonList(newInterval);
        }
        List<Interval> resultList = new ArrayList<Interval>();
        int i = 0;
        //less than
        for( ; i < intervals.size(); i++) {
            Interval item = intervals.get(i);
            if (item.end < newInterval.start) {
                resultList.add(item);
            } else  {
                break;
            }
        }

        //cross area
        for ( ; i < intervals.size(); i++) {
            Interval item = intervals.get(i);
            if (item.start <= newInterval.end) {
                newInterval.start = Math.min(item.start, newInterval.start);
                newInterval.end = Math.max(item.end, newInterval.end);
            } else {
                break;
            }
        }

        resultList.add(newInterval);

        //more than
        for ( ; i < intervals.size(); i++) {
            resultList.add(intervals.get(i));
        }

        return resultList;
    }























































}
