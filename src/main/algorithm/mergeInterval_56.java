package main.algorithm;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class mergeInterval_56 {
    //定义分支类
    private static class Interval{
        int start;
        int end;
        //传入一个数组进行初始化
        public  Interval(int[] interval){
            this.start = interval[0];
            this.end = interval[1];
        }
        //把分支转变成数组，用于返回和输出
        public int[] toArray(){
            return new int[]{this.start,this.end};
        }
    }

    //定义比较器，以分支类的start进行升序排序
    private static class IntervalComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval o1, Interval o2) {
            return Integer.compare(o1.start , o2.start);
        }
    }

    public int[][] merge(int[][] intervals){
        List<Interval> intervalList = new LinkedList<>();
        for(int[] interval : intervals){
            intervalList.add(new Interval(interval));
        }
        //排序
        intervalList.sort(new IntervalComparator());
        //存储合并后的分支
        LinkedList<Interval> merged = new LinkedList<>();

        for(Interval interval : intervalList){
            //如果合并后的分支为空，或者分支中的最后一个分支的end比新分支的start小，就把分支添加到合并的分支中
            if(merged.isEmpty() || merged.getLast().end < interval.start){
                merged.add(interval);
            }else{
                //满足合并条件，取当前分支和新分支中end的最大值，更新分支
                merged.getLast().end = Math.max(merged.getLast().end,interval.end);
            }
        }
        int i = 0;
        int[][] res = new int[merged.size()][2];
        for(Interval interval : merged){
            res[i] = interval.toArray();
            i++;
        }
        return res;
    }
}
