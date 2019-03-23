package sort;

import java.util.Arrays;

public class QuickSort {
    //三分法,找出low，high，mid三者中的最小值，放入low中
    public static int[] get_pivot(int[] arr,int low,int high){
        int mid = (low+high)/2;
        int temp = 0;
        if(arr[high]<arr[mid])  //mid应该比high小
        {
            temp = arr[high];
            arr[high] = arr[mid];
            arr[mid] = temp;
        }
        if(arr[low]>arr[mid])   //low应该比mid小
        {
            temp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = temp;
        }
        return arr;
    }
    //找基准值的下标
    public static int find_pivot(int[] arr,int low,int high){
        get_pivot(arr,low,high);                 //通过三分法确定基数值
        int pivot = arr[low];
        arr[0] = pivot;                          //第一个位置用来存放基数值
        while (low<high)
        {
            while (low < high && pivot <= arr[high])    //找到比基准值小的数，放到前面
                high--;
            arr[low] = arr[high];
            while (low < high && pivot >= arr[low])     //找到比基准值大的数，放到后面
                low++;
            arr[high] = arr[low];
        }
        arr[low] = arr[0];                              //在中间位置放入基准值
        return low;
    }
    //快速排序
    public static int[] quick_sort(int[] arr,int low,int high){
        int pivot;
        if(low < high)
        {
            pivot = find_pivot(arr,low,high);       //获取基准值的下标，便于分割数组
            quick_sort(arr,low,pivot-1);
            quick_sort(arr,pivot+1,high);
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        int[] array = new int[arr.length+1];    //创建一个新数组，第0个元素用于放入基准值。
        System.arraycopy(arr,0,array,1,arr.length);
        array = quick_sort(array,0,array.length-1);
        System.arraycopy(array,1,arr,0,arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ",arr[i]);
        }
    }
}
