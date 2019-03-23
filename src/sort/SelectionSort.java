package sort;

public class SelectionSort {
    //直接选择排序
    public static int[] selection_sort(int[] arr){
        int min,k,temp;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];                           //保存当前待比较的值，用于与后面的未排序的做比较
            temp = arr[i];                          //保存当前待比较的值，用于交换
            k = i;
            for (int j = i; j < arr.length; j++) {  //开始比较
                if(min > arr[j])                    //如果比待比较的还小，
                {
                    k = j;                          //记录更小的值的下标
                    min = arr[j];                   //更新待比较的值
                }

            }
            if(k != i)                              //后面有数字比当前的数字还小，交换
            {
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        arr = selection_sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ",arr[i]);
        }
    }
}
