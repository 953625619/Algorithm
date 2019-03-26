package greed;

import java.util.ArrayList;

public class Activity {
    //先对活动开始时间进行排序
    public static void sort(int[] start, int[] end) {
        for (int i = 1; i < start.length; i++) {
            if (start[i] < start[i - 1]) {
                int j = i - 1;
                int temp1 = start[i];
                int temp2 = end[i];
                for (; j >= 0 && start[j] > temp1; j--) {
                    start[j + 1] = start[j];
                    end[j + 1] = end[j];
                }
                start[j + 1] = temp1;
                end[j + 1] = temp2;
            }
        }
    }

    public static void getActivity(int[] start, int[] end, ArrayList<Integer> selected) {
        int endTime = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < end.length; i++) {  //确定时间结束最早的活动
            if (endTime > end[i]) {
                index = i;                  //记录活动
                endTime = end[i];           //记录结束时间
            }
        }
        selected.add(index);
        for (int i = start[selected.get(0)]; i < start.length; i++) {   //从第一个活动开始
            if (start[i] >= endTime) {        //活动开始时间必须比上个活动的时间晚，不能发生冲突
                endTime = end[i];            //初始化下一个活动的结束时间
                index = i;                  //初始化下一个活动
                for (int j = i; j < end.length; j++){
                    if(end[j] < endTime)    //寻找在开始时间之后最早结束的活动
                    {
                        endTime = end[j];
                        index = j;
                    }
                }
                selected.add(index);        //记录活动
            }
        }
    }

    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};//默认下标从1开始（已非减序排好序），初始的-1无用
        int end[] = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        ArrayList<Integer> selected = new ArrayList<>();
        sort(start, end);
        for (int i = 0; i < start.length; i++) {
            System.out.println("第"+(i+1)+"个活动："+start[i]+"-"+end[i]);
        }
        getActivity(start, end, selected);
        for (int i = 0; i < selected.size(); i++) {
            System.out.printf("第%d个活动被选择 开始时间：%d，结束时间：%d%n", selected.get(i)+1, start[selected.get(i)], end[selected.get(i)]);
        }
    }
}
