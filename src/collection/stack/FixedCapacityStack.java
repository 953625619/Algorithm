package collection.stack;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

/**
固定容量的栈
*/
public class FixedCapacityStack<T> {
    //创建数组保存值
    private  T[] arr;
    //创建顶部指针
    private int N = 0;

    public FixedCapacityStack(Class<T> tClass,int len){
        arr = (T[]) Array.newInstance(tClass, 5);
    }

    //入栈
    public void push(T element) throws IndexOutOfBoundsException{
        if(N < arr.length)
            arr[N++] = element;
        else
            throw new IndexOutOfBoundsException("栈满了");
    }

    //取栈顶元素
    public T peek(){
        if(N>0)
            return arr[N-1];
        else
            return null;
    }

    //出栈
    public void pop() throws EmptyStackException{
        if(N>0)
             arr[--N] = null;
        else
            throw new EmptyStackException();
    }

    //是否为空栈
    public boolean isEmpty(){
        return N==0;
    }

    //栈的大小
    public int size(){
        return N;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(String.class,5);
        System.out.printf("栈是否为空:%s，栈的大小为：%d\n",stack.isEmpty(),stack.size());
        stack.push("H");System.out.print(stack.peek());
        stack.push("E");System.out.print(stack.peek());
        stack.push("L");System.out.print(stack.peek());
        stack.push("L");System.out.print(stack.peek());
        stack.push("O");System.out.print(stack.peek());
        System.out.printf("\n栈是否为空:%s，栈的大小为：%d\n",stack.isEmpty(),stack.size());
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            System.out.printf("%s",stack.peek());
            stack.pop();
        }
        System.out.printf("\n栈是否为空:%s，栈的大小为：%d\n",stack.isEmpty(),stack.size());
    }
}
